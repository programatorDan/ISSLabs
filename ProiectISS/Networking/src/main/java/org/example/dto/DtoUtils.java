package org.example.dto;

import org.example.*;

import java.util.ArrayList;
import java.util.Arrays;

public class DtoUtils {
    public static Admin getFromDto(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setId(adminDto.getId());
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(adminDto.getPassword());
        admin.setPhone(adminDto.getPhone());
        return admin;
    }

    public static AdminDto getDto(Admin admin) {
        return new AdminDto(admin.getEmail(), admin.getPassword(), admin.getPhone(), admin.getId());
    }

    public static Client getFromDto(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setEmail(clientDto.getEmail());
        client.setPassword(clientDto.getPassword());
        client.setPhone(clientDto.getPhone());
        //TODO: private List<Booking> conv
        return client;
    }

    public static ClientDto getDto(Client client) {
        //TODO: private BookingDto[] conv
        return new ClientDto(client.getEmail(), client.getPassword(), client.getPhone(), null, client.getId());
    }

    public static Room getFormDto(RoomDto roomDto) {
        Room room = new Room();
        room.setId(roomDto.getId());
        room.setNumber(roomDto.getNumber());
        room.setSitsPerRow(roomDto.getSitsPerRow());
        room.setRows(roomDto.getRows());
        //TODO: private List<Movie> conv
        return room;
    }

    public static RoomDto getDto(Room room) {
        //TODO: private MovieDto[] conv
        return new RoomDto(room.getNumber(), room.getSitsPerRow(), room.getRows(), room.getId(), null);
    }

    public static Movie getFromDto(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setId(movieDto.getId());

        //TODO: private List<Ticket> conv
        movie.setTimestamp(movieDto.getTimestamp());
        movie.setTitle(movieDto.getTitle());
        return movie;
    }

    public static MovieDto getDto(Movie movie) {
        //TODO: private TicketDto[] conv
        return new MovieDto(movie.getTitle(), movie.getTimestamp(), getDto(movie.getRoom()), null, movie.getId());
    }

    public static Ticket getFromDto(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDto.getId());
        ticket.setPrice(ticketDto.getPrice());
        ticket.setRow(ticketDto.getRow());
        ticket.setSit(ticketDto.getSit());
        ticket.setMovie(getFromDto(ticketDto.getMovie()));
        //TODO: Booking conv
        return ticket;
    }

    public static TicketDto getDto(Ticket ticket) {
        //TODO: bookingDto conv
        return new TicketDto(ticket.getPrice(), ticket.getRow(), ticket.getSit(), getDto(ticket.getMovie()), null, ticket.getId());
    }

    public static Booking getFromDto(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        //TODO: private List<ticket> conv
        booking.setBoughtBy(getFromDto(bookingDto.getBoughtBy()));
        return booking;
    }

    public static BookingDto getDto(Booking booking) {
        //TODO: private ticketDto[] conv
        return new BookingDto(getDto(booking.getBoughtBy()), null, booking.getId());
    }
}
