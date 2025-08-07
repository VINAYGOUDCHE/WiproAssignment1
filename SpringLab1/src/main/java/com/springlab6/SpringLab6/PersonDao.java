package com.springlab6.SpringLab6;

import java.util.List;

public interface PersonDao {
    void save(Person person);
    void update(Person person);
    void delete(int id);
    Person getById(int id);
    List<Person> getAll();
}