package com.pbido.booktracker.adapter.output.repository;

import com.pbido.booktracker.core.domain.Book;
import com.pbido.booktracker.core.domain.ReadingStatus;
import com.pbido.booktracker.port.output.RepositoryOutputPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2DatabaseRepository implements RepositoryOutputPort {

    private static final String DB_URL = "jdbc:h2:file:/data/books";
    private static final String USER = "pbido";
    private static final String PASS = "admin";

    @Override
    public void save(Book book) {
        try {
            Connection conn = getConnection();

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

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to H2");
        }
    }

    @Override
    public List<Book> getBookByTitle(String title) {

        List<Book> listOfBooks = new ArrayList<>();

        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM BOOKS WHERE TITLE=?");
            pstmt.setString(1, title);
            pstmt.executeQuery();
            ResultSet rs = pstmt.getResultSet();

            while (rs.next()) {
                Book book = new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        ReadingStatus.COMPLETED,
                        0.0,
                        rs.getInt("total_pages"),
                        0);

                listOfBooks.add(book);
            }

        } catch (Exception e) {
            System.out.println("ERROR getting data from H2 Database: " + e.getCause());
        }
        return listOfBooks;
    }
}
