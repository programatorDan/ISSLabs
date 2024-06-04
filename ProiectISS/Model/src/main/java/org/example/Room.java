package org.example;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table( name = "room")
public class Room extends org.example.Entity<Long> {
    private int Number;
    private int SitsPerRow;
    private int Rows;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    private List<Movie> movies;

    @Column(name = "number")
    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    @Column(name = "sits")
    public int getSitsPerRow() {
        return SitsPerRow;
    }

    public void setSitsPerRow(int sitsPerRow) {
        SitsPerRow = sitsPerRow;
    }

    @Column(name = "rows")
    public int getRows() {
        return Rows;
    }

    public void setRows(int rows) {
        Rows = rows;
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
