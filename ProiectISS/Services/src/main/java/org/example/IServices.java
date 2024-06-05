package org.example;

public interface IServices {
    void login(Client user, IObserver client) throws ServiceException;
    Client findClient(Client client) throws ServiceException;
}
