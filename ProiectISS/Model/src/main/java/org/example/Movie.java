package org.example;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table( name = "movie")
public class Movie extends org.example.Entity<Long> {
    private String Title;
    private LocalDateTime Timestamp;
    private Room Room;
    private List<Ticket> Tickets;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Ticket> getTickets() {
        return Tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        Tickets = tickets;
    }

    @Column(name = "title")
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Column(name = "timestamp")
    public LocalDateTime getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        Timestamp = timestamp;
    }

    @ManyToOne
    @JoinColumn(name = "room")
    public org.example.Room getRoom() {
        return Room;
    }

    public void setRoom(org.example.Room room) {
        Room = room;
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
