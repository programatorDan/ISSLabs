package org.example;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table( name = "client")
public class Client extends org.example.Entity<Long> {
    private String Email;
    private String Password;
    private String Phone;

    private List<Booking> bookings;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Column( name = "email" )
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Column( name = "password")
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Column( name = "phone")
    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
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
