package com.amazefulbot.WebServer.repository;

import com.amazefulbot.WebServer.models.Filters;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FiltersRepository extends MongoRepository<Filters, String> {
    Optional<Filters> findForChannelById(int id);

}
