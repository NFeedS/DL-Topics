package com.nfeeds.data.topics.repository;

import com.nfeeds.data.topics.model.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * <p> Interface used by Spring Data Rest to create CRUD endpoints over the User table. </p>
 * <p> The base endpoints generated will have the form: </p>
 * <code>
 * <p><i> GET|POST : {basePath}/topics </i></p>
 * <p><i> GET|POST|PUT|DELETE : {basePath}/topics/{id} </i></p>
 * </code>
 * <p>(plus the /profile and OPTIONS endpoint to get the endpoints metadata and options) </p>
 * <p>
 * <p> Additional endpoint will be created based on the query functions of the interface: </p>
 * <code><p><i> GET : {basePath}/topics/search/{specified_path|function_name}?{parameters} </i></p></code>
 * <p>
 * <p> The response of the endpoint will follow HATEOAS specifications. </p>
 */
public interface TopicRepository extends CrudRepository<Topic, String> {

    /**
     * <p> Search all the topics belonging to a certain user.</p>
     * <code><p><i> GET : {basePath}/topics/search/owner?id={user_id} </i></p></code>
     * <p>
     * @param user_id The id of the user owner of the topics searched.
     * @return The list of topics that belong to the user indicated by user_id.
     */
    @RestResource(path = "owner" ,rel = "byOwner")
    List<Topic> findByOwner(@Param("id") String user_id);

}
