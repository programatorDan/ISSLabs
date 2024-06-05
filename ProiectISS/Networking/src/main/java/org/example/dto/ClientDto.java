package org.example.dto;

import java.io.Serializable;

public class ClientDto implements Serializable {
    private String Email;
    private String Password;
    private String Phone;
    private BookingDto bookings;
    private Long Id;

    public ClientDto(String email, String password, String phone, BookingDto bookings, Long id) {
        Email = email;
        Password = password;
        Phone = phone;
        this.bookings = bookings;
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhone() {
        return Phone;
    }

    public BookingDto getBookings() {
        return bookings;
    }

    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Phone='" + Phone + '\'' +
                ", bookings=" + bookings +
                ", Id=" + Id +
                '}';
    }
}
