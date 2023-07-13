package com.practice.OneOneBi.Controller;

import com.practice.OneOneBi.Entity.Laptop;
import com.practice.OneOneBi.Entity.Person;
import com.practice.OneOneBi.Service.LaptopService;
import com.practice.OneOneBi.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PersonController {
    @Autowired
    public PersonService personService;
    @Autowired
    public LaptopService laptopService;

    @GetMapping("/person")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }

    @GetMapping("/person/{id}")
    public Person getById(@PathVariable("id") int id){
        return personService.getByID(id);
    }

    @PutMapping("/person/{id}")
    public Person Update(@RequestBody Person updatedPerson,@PathVariable("id")int id){
        Person existingPerson = personService.getByID(id);

        existingPerson.setName(updatedPerson.getName());
        existingPerson.setPhone_no(updatedPerson.getPhone_no());

        Laptop laptop = updatedPerson.getLaptop();
        if (laptop != null) {
            Laptop currentLaptop = existingPerson.getLaptop();
            if (currentLaptop != null) {
                // Preserve the original laptop ID
                laptop.setId(currentLaptop.getId());
            }
            laptop.setPerson(existingPerson);
            existingPerson.setLaptop(laptop);
        }


        return personService.updatePerson(existingPerson);
    }

    @PostMapping("/person")
    public Person Create(@RequestBody Person person){


        return personService.SavePerson(person);
    }

    @DeleteMapping("/person/{id}")
    public void delete(@PathVariable("id")int id){
         personService.deletePerson(id);
    }
}
