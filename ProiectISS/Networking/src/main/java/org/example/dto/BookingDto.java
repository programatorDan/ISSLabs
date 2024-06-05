package org.example.dto;

import java.io.Serializable;
import java.util.Arrays;

public class BookingDto implements Serializable {
    private ClientDto BoughtBy;
    private TicketDto[] Tickets;
    private Long Id;

    public BookingDto(ClientDto boughtBy, TicketDto[] tickets, Long id) {
        BoughtBy = boughtBy;
        Tickets = tickets;
        Id = id;
    }

    public ClientDto getBoughtBy() {
        return BoughtBy;
    }

    public TicketDto[] getTickets() {
        return Tickets;
    }

    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "BoughtBy=" + BoughtBy +
                ", Tickets=" + Arrays.toString(Tickets) +
                ", Id=" + Id +
                '}';
    }
}
