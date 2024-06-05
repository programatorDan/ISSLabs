package org.example.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;

public class MovieDto implements Serializable {
    private String Title;
    private LocalDateTime Timestamp;
    private RoomDto Room;
    private TicketDto[] Tickets;
    private Long Id;

    public MovieDto(String title, LocalDateTime timestamp, RoomDto room, TicketDto[] tickets, Long id) {
        Title = title;
        Timestamp = timestamp;
        Room = room;
        Tickets = tickets;
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public LocalDateTime getTimestamp() {
        return Timestamp;
    }

    public RoomDto getRoom() {
        return Room;
    }

    public TicketDto[] getTickets() {
        return Tickets;
    }

    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "Title='" + Title + '\'' +
                ", Timestamp=" + Timestamp +
                ", Room=" + Room +
                ", Tickets=" + Arrays.toString(Tickets) +
                ", Id=" + Id +
                '}';
    }
}
