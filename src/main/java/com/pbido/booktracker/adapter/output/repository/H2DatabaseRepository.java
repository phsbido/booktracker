package com.pbido.booktracker.adapter.output.repository;

import com.pbido.booktracker.core.domain.Book;
import com.pbido.booktracker.port.output.RepositoryOutputPort;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2DatabaseRepository implements RepositoryOutputPort {

    private static final String DB_URL = "jdbc:h2:file:/data/books";
    private static final String USER = "pbido";
    private static final String PASS = "admin";

    @Override
    public void save(Book book){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String insertSQL = "INSERT INTO BOOKS (title, author, status, total_pages) VALUES (?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getStatus().ordinal());
            pstmt.setInt(4, book.getTotalPages());
            pstmt.executeUpdate();
            System.out.println("Data saved successfully!");
        } catch (Exception e) {
            System.out.println("ERROR saving data to H2 Database: " + e.getCause());
        }
    }
}
