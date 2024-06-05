package org.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServicesImp implements IServices {
    private RepoAdmin repoAdmin;
    private RepoClient repoClient;
    private RepoBooking repoBooking;
    private RepoMovie repoMovie;
    private RepoTicket repoTicket;
    private RepoRoom repoRoom;
    private Map<String, IObserver> loggedClients;

    public ServicesImp(RepoAdmin repoAdmin, RepoClient repoClient, RepoBooking repoBooking, RepoMovie repoMovie, RepoTicket repoTicket, RepoRoom repoRoom) {
        this.repoAdmin = repoAdmin;
        this.repoClient = repoClient;
        this.repoBooking = repoBooking;
        this.repoMovie = repoMovie;
        this.repoTicket = repoTicket;
        this.repoRoom = repoRoom;
        loggedClients = new ConcurrentHashMap<>();
    }

    @Override
    public void login(Client user, IObserver client) throws ServiceException {
        Client cl = repoClient.findOne(user.getEmail(), user.getPassword());
        if (cl != null) {
            if (loggedClients.get(user.getEmail()) != null) {
                throw new ServiceException("User already logged in.");
            }
            loggedClients.put(user.getEmail(), client);
        } else {
            throw new ServiceException("Authentication failed.");
        }
    }

    @Override
    public Client findClient(Client client) throws ServiceException {
        return repoClient.findOne(client.getEmail(), client.getPassword());
    }
}
