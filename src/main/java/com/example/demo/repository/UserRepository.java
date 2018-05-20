package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by leizhang on 2/27/18.
 */
public interface UserRepository extends MongoRepository<User, String> {

    public User findByUsername(String username);

}
