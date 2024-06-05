package org.example.dto;

import java.io.Serializable;

public class RoomDto implements Serializable {
    private int Number;
    private int SitsPerRow;
    private int Rows;
    private Long Id;
    private MovieDto[] movies;

    public MovieDto[] getMovies() {
        return movies;
    }

    public RoomDto(int number, int sitsPerRow, int rows, Long id, MovieDto[] movies) {
        Number = number;
        SitsPerRow = sitsPerRow;
        Rows = rows;
        Id = id;
        this.movies = movies;
    }

    public int getNumber() {
        return Number;
    }

    public int getSitsPerRow() {
        return SitsPerRow;
    }

    public int getRows() {
        return Rows;
    }

    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "RoomDto{" +
                "Number=" + Number +
                ", SitsPerRow=" + SitsPerRow +
                ", Rows=" + Rows +
                ", Id=" + Id +
                '}';
    }
}
