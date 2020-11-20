package com.armanfar.springdemo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopicById(@PathVariable Integer id) {
        return topicService.getTopicById(id);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public String addTopic(@RequestBody Topic topic) {
        return topicService.addTopics(topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    public String updateTopic(@RequestBody Topic topic, @PathVariable Integer id) {
        return topicService.updateTopics(topic, id);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.DELETE)
    public String deleteTopicAllTopics() {
        return topicService.deleteAllTopics();
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public String deleteTopicById(@PathVariable Integer id) {
        return topicService.deleteTopicById(id);
    }
}
