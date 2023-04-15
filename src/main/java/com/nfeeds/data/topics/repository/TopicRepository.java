package com.nfeeds.data.topics.repository;

import com.nfeeds.data.topics.model.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, String> {

    @RestResource(path = "owner" ,rel = "byOwner")
    List<Topic> findByOwner(@Param("id") String user_id);

}
