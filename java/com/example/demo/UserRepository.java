package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.User;

public interface UserRepository extends MongoRepository<User,Integer> {

     User findByUsernameAndPassword(String username,String password);
     User findByUsername(String username);
}

