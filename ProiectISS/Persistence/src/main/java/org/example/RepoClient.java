package org.example;

import org.hibernate.Session;

public class RepoClient {
    public void addClient(Client client) {
        HibernateUtils.getClient().inTransaction(session -> session.persist(client));
    }

    public Client findOne(String name, String pass) {
        Client client = null;
        try (Session session = HibernateUtils.getClient().openSession()) {
            client = session.createSelectionQuery("from Client where email=:name and password=:pass", Client.class)
                    .setParameter("name", name).setParameter("pass", pass).getSingleResultOrNull();
        } catch (Exception e) {
            throw e;
        }
        return client;
    }
}
