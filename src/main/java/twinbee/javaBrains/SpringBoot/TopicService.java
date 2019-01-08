/**
 * 
 */
package twinbee.javaBrains.SpringBoot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author matthew
 *
 */

//TODO replace literal default data with a DB access
@RestController
public class TopicService {
	public List<Topic> getTopics() {
		return new ArrayList<Topic>(topics);
		// return topics;
	}

	public void setTopics(List<Topic> topics) {
		topics = new ArrayList<Topic>(topics);
		// this.topics = topics;
	}

	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("spring", "Spring Essentials", "An introduction to Spring"),
			new Topic("spring-adv", "Spring Advanced", "Using Spring to develop applications"), new Topic("spring-boot",
					"Spring Boot", "This course, on Spring Boot, which you are currently working on!")));

	public Topic getTopic(String id) {
		// yay lambdas! stream should return null if id is not found? nope,
		// noSuchElementException
		try {
			return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		} catch (NoSuchElementException e) {
			return new Topic(id, " There is no course topic with the name " + id, "");
		}

	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	private ListIterator<Topic> iterator = topics.listIterator();

	public void updateTopic(String id, Topic topic) {

		while (iterator.hasNext()) {
			Topic next = iterator.next();
			if (next.getId().equals(id)) {
				iterator.set(topic);
			}
		}
	}

	public void deleteTopic(String id) {

		while (iterator.hasNext()) {
			Topic next = iterator.next();
			if (next.getId().equals(id)) {
				iterator.remove();
			}
		}
	}

}
