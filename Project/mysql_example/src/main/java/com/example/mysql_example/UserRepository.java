package com.example.mysql_example;

import org.springframework.data.repository.CrudRepository;

import com.example.mysql_example.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}
