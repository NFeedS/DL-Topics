package com.nfeeds.data.topics.controller;

import com.nfeeds.data.topics.model.Topic;
import com.nfeeds.data.topics.repository.TopicRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/topics")
public class TopicsController {
	
	private final TopicRepository topicRepository;
	
	@PostMapping("/")
	public Topic newTopic(@RequestBody Topic body){
		log.debug(this.getClass().getSimpleName() + " - newTopic");
		return topicRepository.save(body);
	}
	
	@GetMapping("/")
	public List<Topic> getAllTopics(){
		log.debug(this.getClass().getSimpleName() + " - getAllTopics");
		return topicRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Topic getTopic(@PathVariable("id") String topic_id){
		log.debug(this.getClass().getSimpleName() + " - getTopic");
		return topicRepository.findById(topic_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic "+topic_id+" not found"));
	}
	
	@GetMapping("/owner/{id}")
	public List<Topic> getTopicByOwner(@PathVariable("id") String owner_id){
		log.debug(this.getClass().getSimpleName() + " - getTopicByOwner");
		return topicRepository.getTopicsByOwner(owner_id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTopic(@PathVariable("id") String topic_id){
		log.debug(this.getClass().getSimpleName() + " - deleteTopic");
		topicRepository.deleteById(topic_id);
	}
}
