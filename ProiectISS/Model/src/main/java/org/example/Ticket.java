package org.example;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table( name = "ticket")
public class Ticket extends org.example.Entity<Long> {
    private double Price;
    private int Row;
    private int Sit;
    private Movie Movie;
    private Booking Booking;

    @ManyToOne
    @JoinColumn(name = "booking")
    public org.example.Booking getBooking() {
        return Booking;
    }

    public void setBooking(org.example.Booking booking) {
        Booking = booking;
    }

    @ManyToOne
    @JoinColumn(name = "movie")
    public org.example.Movie getMovie() {
        return Movie;
    }

    public void setMovie(org.example.Movie movie) {
        Movie = movie;
    }

    @Column(name = "price")
    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Column(name = "row")
    public int getRow() {
        return Row;
    }

    public void setRow(int row) {
        Row = row;
    }

    @Column(name = "sit")
    public int getSit() {
        return Sit;
    }

    public void setSit(int sit) {
        Sit = sit;
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    @Id
    @GeneratedValue(generator = "increment")
    public Long getId() {
        return this.Id;
    }
}
