package com.springMongo.rafael.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springMongo.rafael.domain.User;

@Repository
public interface UserRepositories extends MongoRepository<User, String> {

}
