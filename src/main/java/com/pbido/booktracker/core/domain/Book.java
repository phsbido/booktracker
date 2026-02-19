package com.pbido.booktracker.core.domain;

public class Book {
    private static final long serialVersionUID = 1L;
    private String title;
    private String author;
    private ReadingStatus status;
    private double rating;
    private int totalPages;
    private int pagesRead;

    public Book() {
    }

    public Book(String title, String author, ReadingStatus status, double rating, int totalPages, int pagesRead) {
        this.title = title;
        this.author = author;
        this.status = status;
        this.rating = rating;
        this.totalPages = totalPages;
        this.pagesRead = pagesRead;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public ReadingStatus getStatus() {
        return status;
    }

    public void setStatus(ReadingStatus status) {
        this.status = status;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }
}
