package com.practice.OneOneBi.Service;

import com.practice.OneOneBi.Entity.Laptop;
import com.practice.OneOneBi.Entity.Person;
import com.practice.OneOneBi.Repository.LaptopRepository;
import com.practice.OneOneBi.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class LaptopService {
    @Autowired
    public LaptopRepository laptopRepository;
    @Autowired
            public PersonRepository personRepository;

    public List<Laptop> getAllLaptop(){
        return (List<Laptop>) laptopRepository.findAll();
    }
    public Laptop Save(Laptop laptop){

        laptopRepository.save(laptop);


        return laptop;
    }
    public Laptop getById(int id){
        return laptopRepository.findById(id);
    }

    public void deleteLaptop(int id){
        laptopRepository.deleteById(id);
    }

    public Laptop UpdateLaptop(Laptop laptop,int id){

        return laptopRepository.save(laptop);
    }
}
