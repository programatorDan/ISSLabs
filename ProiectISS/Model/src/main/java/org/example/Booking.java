package org.example;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table( name = "booking")
public class Booking extends org.example.Entity<Long> {
    private Client BoughtBy;
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client")
    public Client getBoughtBy() {
        return BoughtBy;
    }

    public void setBoughtBy(Client boughtBy) {
        BoughtBy = boughtBy;
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
