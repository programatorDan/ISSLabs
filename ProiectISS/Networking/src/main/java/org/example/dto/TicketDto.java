package org.example.dto;

import java.io.Serializable;

public class TicketDto implements Serializable {
    private double Price;
    private int Row;
    private int Sit;
    private MovieDto Movie;
    private BookingDto Booking;
    private Long Id;

    public TicketDto(double price, int row, int sit, MovieDto movie, BookingDto booking, Long id) {
        Price = price;
        Row = row;
        Sit = sit;
        Movie = movie;
        Booking = booking;
        Id = id;
    }

    public double getPrice() {
        return Price;
    }

    public int getRow() {
        return Row;
    }

    public int getSit() {
        return Sit;
    }

    public MovieDto getMovie() {
        return Movie;
    }

    public BookingDto getBooking() {
        return Booking;
    }

    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "Price=" + Price +
                ", Row=" + Row +
                ", Sit=" + Sit +
                ", Movie=" + Movie +
                ", Booking=" + Booking +
                ", Id=" + Id +
                '}';
    }
}
