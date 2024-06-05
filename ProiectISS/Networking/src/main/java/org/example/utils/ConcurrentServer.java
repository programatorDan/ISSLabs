package org.example.utils;

import org.example.IServices;
import org.example.rpc.ClientWorker;

import java.net.Socket;

public class ConcurrentServer extends AbsConcurrentServer {
    private IServices server;

    public ConcurrentServer(int port, IServices server) {
        super(port);
        this.server = server;
    }

    @Override
    protected Thread createWorker(Socket client) {
        ClientWorker worker = new ClientWorker(server, client);
        Thread tw = new Thread(worker);

        return tw;
    }
}
