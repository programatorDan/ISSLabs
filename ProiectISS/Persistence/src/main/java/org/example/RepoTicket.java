package org.example;

public class RepoTicket {
    public void addTicket(Ticket ticket) {
        HibernateUtils.getTicket().inTransaction(session -> session.persist(ticket));
    }
}
