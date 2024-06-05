package org.example;

import org.example.utils.AbstractServer;
import org.example.utils.ConcurrentServer;

public class StartServer {
    public static void main(String[] args) {
        RepoClient repoClient = new RepoClient();
        RepoAdmin repoAdmin = new RepoAdmin();
        RepoBooking repoBooking = new RepoBooking();
        RepoMovie repoMovie = new RepoMovie();
        RepoTicket repoTicket = new RepoTicket();
        RepoRoom repoRoom = new RepoRoom();
        IServices serverImp = new ServicesImp(repoAdmin, repoClient, repoBooking, repoMovie,
                repoTicket, repoRoom);
        int serverPort = 55555;
        AbstractServer server = new ConcurrentServer(serverPort, serverImp);
        try {
            server.start();
        } catch (Exception e) {
            System.err.println("Error starting the server " + e.getMessage());
        } finally {
            try {
                server.stop();
            } catch (Exception e) {
                System.err.println("Error stopping the server " + e.getMessage());
            }
        }
    }
}
