package org.example.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Book {
    private int id;

    @NotEmpty(message = "Название книги не может быть пустым")
    @Size(min = 3, message = "Название книги должно быть длиннее 2 символов")
    private String name;

    @NotEmpty(message = "Имя автора не может быть пустым")
    @Size(min = 3, message = "Имя автора должно быть длиннее 2 символов")
    private String author;

    private int year;


    public Book(String name, String author, int year, int userId) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public Book(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
