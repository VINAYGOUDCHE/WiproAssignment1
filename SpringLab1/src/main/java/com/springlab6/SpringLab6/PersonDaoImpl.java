package com.springlab6.SpringLab6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Person person) {
        String sql = "INSERT INTO person (id, first_name, last_name, age) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, person.getId(), person.getFirstName(), person.getLastName(), person.getAge());
    }

    @Override
    public void update(Person person) {
        String sql = "UPDATE person SET first_name=?, last_name=?, age=? WHERE id=?";
        jdbcTemplate.update(sql, person.getFirstName(), person.getLastName(), person.getAge(), person.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM person WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Person getById(int id) {
        String sql = "SELECT * FROM person WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new PersonRowMapper(), id);
    }

    @Override
    public List<Person> getAll() {
        String sql = "SELECT * FROM person";
        return jdbcTemplate.query(sql, new PersonRowMapper());
    }
}