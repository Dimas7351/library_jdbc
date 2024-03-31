package org.example.dao;


import org.example.models.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Book book = new Book();

        book.setId(resultSet.getInt("id"));
        book.setName(resultSet.getString("book_name"));
        book.setAuthor(resultSet.getString("author_name"));
        book.setYear(resultSet.getInt("year"));
//        book.setUser_id(resultSet.getInt("user_id"));

        return book;

    }
}
