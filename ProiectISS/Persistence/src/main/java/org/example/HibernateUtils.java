package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory client;
    private static SessionFactory admin;
    private static SessionFactory booking;
    private static SessionFactory ticket;
    private static SessionFactory movie;
    private static SessionFactory room;

    public static SessionFactory getClient() {
        if ((client == null) || (client.isClosed())) {
            client = createNewSessionFactory(Client.class);
        }
        return client;
    }

    public static SessionFactory getAdmin() {
        if ((admin == null) || (admin.isClosed())) {
            admin = createNewSessionFactory(Admin.class);
        }
        return admin;
    }

    public static SessionFactory getBooking() {
        if ((booking == null) || (booking.isClosed())) {
            booking = createNewSessionFactory(Booking.class);
        }
        return booking;
    }

    public static SessionFactory getTicket() {
        if ((ticket == null) || (ticket.isClosed())) {
            ticket = createNewSessionFactory(Ticket.class);
        }
        return ticket;
    }

    public static SessionFactory getMovie() {
        if ((movie == null) || (movie.isClosed())) {
            movie = createNewSessionFactory(Movie.class);
        }
        return movie;
    }

    public static SessionFactory getRoom() {
        if ((room == null) || (room.isClosed())) {
            room = createNewSessionFactory(Room.class);
        }
        return room;
    }

    private static SessionFactory createNewSessionFactory(Class tmp) {
        return new Configuration()
                .addAnnotatedClass(tmp)
                .buildSessionFactory();
    }
}
