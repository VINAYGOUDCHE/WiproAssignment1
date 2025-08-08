package com.springlabs.lab12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM books";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }
}