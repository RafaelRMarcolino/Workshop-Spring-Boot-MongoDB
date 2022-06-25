package com.springMongo.rafael.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springMongo.rafael.domain.Post;

@Repository
public interface PostRepositories extends MongoRepository<Post, String> {

}
