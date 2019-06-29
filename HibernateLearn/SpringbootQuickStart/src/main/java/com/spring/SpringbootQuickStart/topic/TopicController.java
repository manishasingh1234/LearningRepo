package com.spring.SpringbootQuickStart.topic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public ResponseEntity<Topic> getTopic(@PathVariable String id){
		
		Topic topic = topicService.getTopic(id);
		/*HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setAccessControlMaxAge(1000000000);
		responseHeaders.setCacheControl(cacheControl);*/
		
		System.out.println("get Topic for id : "+id);
		return ResponseEntity.ok()
        .cacheControl(CacheControl.maxAge(600, TimeUnit.SECONDS))
        .body(topic);
		 
	}
	
	@RequestMapping(value="/topics",method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic){
		topicService.addTopic(topic);
	}
	
	@RequestMapping(value="/topics/{id}",method=RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
		topicService.updateTopic(topic,id);
	}
}
