package com.gurkan.shortlink.repository;

import com.gurkan.shortlink.entity.Link;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkRepository extends MongoRepository<Link, String> {

    Optional<Link> findByCodeEquals(String code);
}
