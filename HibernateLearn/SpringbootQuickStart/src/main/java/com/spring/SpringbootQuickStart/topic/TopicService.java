package com.spring.SpringbootQuickStart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	List<Topic> topics = 
			 new ArrayList<>(Arrays.asList(new Topic("spring", "Spring Framework", "Dependency injection"),
					new Topic("java", "Core Java", "Dependency injection")));
	
	@Autowired
	TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id){
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic){
		//topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for(int i =0;i<topics.size();i++){
			if(topics.get(i).getId().equals(id)){
				topics.set(i, topic);
			}
		}
		
	}
}
