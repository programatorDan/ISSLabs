package org.example;

public class RepoBooking {
    public void addBooking(Booking booking) {
        HibernateUtils.getBooking().inTransaction(session -> session.persist(booking));
    }
}
