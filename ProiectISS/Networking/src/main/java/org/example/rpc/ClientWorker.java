package org.example.rpc;

import org.example.Client;
import org.example.IObserver;
import org.example.IServices;
import org.example.ServiceException;
import org.example.dto.ClientDto;
import org.example.dto.DtoUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class ClientWorker implements Runnable, IObserver {
    private IServices server;
    private Socket connection;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private volatile boolean connected;

    public ClientWorker(IServices server, Socket connection) {
        this.server = server;
        this.connection = connection;
        try {
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input =new ObjectInputStream(connection.getInputStream());
            connected = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (connected) {
            try {
                Object request = input.readObject();
                Response response = handleRequest((Request) request);
                if (response != null) {
                    sendResponse(response);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            input.close();
            output.close();
            connection.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Response handleRequest(Request request) {
        Response response = null;
        String handleName = "handle" + (request).getType();
        System.out.println("call to " + handleName);
        try {
            Method method = this.getClass().getDeclaredMethod(handleName, Request.class);
            response = (Response) method.invoke(this, request);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return response;
    }

    private static Response okResponse = new Response.Builder().type(ResponseType.OK).build();

    private Response handleLOGIN(Request request) {
        System.out.println("Login request...");
        ClientDto clientDto = (ClientDto) request.getData();
        Client client = DtoUtils.getFromDto(clientDto);
        try {
            server.login(client, this);
            return okResponse;
        } catch (ServiceException e) {
            connected = false;
            return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
        }
    }

    private Response handleFIND_CLIENT(Request request) {
        System.out.println("Find client request ...");
        ClientDto clientDto = (ClientDto) request.getData();
        Client client = DtoUtils.getFromDto(clientDto);
        try {
            Client rez = server.findClient(client);
            ClientDto rezDto = DtoUtils.getDto(rez);
            return new Response.Builder().type(ResponseType.GET_CLIENT).data(rezDto).build();
        } catch (ServiceException e) {
            return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
        }
    }

    private void sendResponse(Response response) throws IOException {
        System.out.println("Sending " + response);
        synchronized (output) {
            output.writeObject(response);
            output.flush();
        }
    }
}
