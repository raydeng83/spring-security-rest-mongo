package com.example.demo.repository;

import com.example.demo.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by leizhang on 2/27/18.
 */
public interface RoleRepository extends MongoRepository<Role, String> {
    public Role findByRole(String role);
}
