package com.example.demo;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();
        roleRepository.deleteAll();
        roleRepository.save(new Role("ROLE_USER"));
        roleRepository.save(new Role("ROLE_ADMIN"));

        // save a couple of customers
        repository.save(new User("lztest00", "Lei", "Zhang", "password"));
        repository.save(new User("lztest01", "Lei", "Zhang", "password"));
        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (User user : repository.findAll()) {
            System.out.println(user);
        }
        System.out.println();

    }
}
