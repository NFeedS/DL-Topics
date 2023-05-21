package com.nfeeds.data.topics.repository;

import com.nfeeds.data.topics.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, String> {
    
    List<Topic> getTopicsByOwner(String owner);

}
