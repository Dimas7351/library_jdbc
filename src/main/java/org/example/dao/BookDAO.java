package org.example.dao;

import org.example.models.Book;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("SELECT * FROM Book", new BookMapper());
    }



    public Book show(int id){
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id},
                new BookMapper()).stream().findAny().orElse(null);
    }

    public void save(Book book){
        jdbcTemplate.update("INSERT INTO Book(book_name, author_name, year) VALUES (?,?,?)", book.getName(), book.getAuthor(), book.getYear());
    }

    public void update(int id, Book updatedBook){
        jdbcTemplate.update("UPDATE Book SET book_name=?, author_name=?, year=? WHERE id=?",
                updatedBook.getName(), updatedBook.getAuthor(), updatedBook.getYear(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }


    public void setUser(int book_id, int person_id){
        jdbcTemplate.update("UPDATE Book SET user_id=? WHERE id=?",
                person_id, book_id);
    }

    public Optional<Person> getUserOfBook(int book_id){
        return jdbcTemplate.query("SELECT Person.* FROM Person JOIN Book ON Book.user_id=Person.id WHERE Book.id=?",
                new Object[]{book_id}, new PersonMapper()).stream().findAny();
    }

    public void releaseBook(int id){
        jdbcTemplate.update("UPDATE Book SET user_id=NULL WHERE id=?", id);
    }
}
