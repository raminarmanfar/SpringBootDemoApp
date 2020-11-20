package com.armanfar.springdemo.topic;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    private List<Topic> topics =new ArrayList<>(Arrays.asList(
            new Topic(10, "Math", "Ramin's description."),
            new Topic(20, "C#", "Amin's description."),
            new Topic(30, "Java", "Roya's description."),
            new Topic(40, "Angular", "Amir's description.")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopicById(int id) {
        return topics.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    public String addTopics(Topic topic) {
        if (topics.stream().filter(item -> item.getId() == topic.getId()).count() > 0) {
            return "Topic with id " + topic.getId() + " has already been exist in the list.";
        }
        topics.add(topic);
        return "New topic with id " + topic.getId() + " has been added.";
    }

    public String updateTopics(Topic topic, Integer id) {
        for(Topic t: topics) {
            if (t.getId() == id) {
                if (id != topic.getId() && topics.stream().filter(item -> item.getId() == topic.getId()).count() > 0) {
                    return "Error: The topic with id " + topic.getId() + " has already been exist in the list.";
                }
                topics.set(topics.indexOf(t), topic);
                return "Topic with id " + id + " has been updated.";
            }
        }

        return "Topic with id " + id + " not found.";
    }

    public String deleteTopicById(Integer id) {
        boolean isRemoved = topics.removeIf(item -> item.getId() == id);
        return "Topic with id " + id + (isRemoved ? " has been removed." : " not found in the list.");
    }

    public String deleteAllTopics() {
        topics.clear();
        return "All topics have been removed.";
    }
}
