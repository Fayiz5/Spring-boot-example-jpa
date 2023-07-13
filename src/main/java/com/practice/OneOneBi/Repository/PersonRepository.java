package com.practice.OneOneBi.Repository;

import com.practice.OneOneBi.Entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Integer> {
    public Person findById(int id);
}
