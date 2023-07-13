package com.practice.OneOneBi.Repository;

import com.practice.OneOneBi.Entity.Laptop;
import org.springframework.data.repository.CrudRepository;

public interface LaptopRepository extends CrudRepository<Laptop,Integer> {
    public Laptop findById(int id);
}
