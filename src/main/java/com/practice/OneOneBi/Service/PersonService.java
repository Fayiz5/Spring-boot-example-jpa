package com.practice.OneOneBi.Service;

import com.practice.OneOneBi.Entity.Laptop;
import com.practice.OneOneBi.Entity.Person;
import com.practice.OneOneBi.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PersonService {
    @Autowired
    public PersonRepository personRepository;

    public List<Person> getAllPerson(){
        return (List<Person>) personRepository.findAll();
    }
    public Person SavePerson(Person person){
        return  personRepository.save(person);
    }
    public Person getByID( int id){
        return personRepository.findById(id);
    }
    public Person updatePerson(Person person){

        return personRepository.save(person);
    }
    public void deletePerson(int id){
        personRepository.deleteById(id);
    }
}
