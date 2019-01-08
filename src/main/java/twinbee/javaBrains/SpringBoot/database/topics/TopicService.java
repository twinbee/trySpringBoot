/**
 * 
 */
package twinbee.javaBrains.SpringBoot.database.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matthew
 *
 */

@RestController
public class TopicService {

	@Autowired
	private ITopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		List<Topic> rettopics = new ArrayList<Topic>();

		topicRepository.findAll().forEach(rettopics::add);
		return rettopics;

	}

	public Topic getTopic(String id) {
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}

}
