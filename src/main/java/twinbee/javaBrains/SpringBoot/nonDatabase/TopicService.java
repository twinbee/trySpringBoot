/**
 * 
 */
package twinbee.javaBrains.SpringBoot.nonDatabase;

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
	public List<Topic> gettopics() {
		return new ArrayList<Topic>(topics);
		// return topics;
	}

	public void settopics(List<Topic> topics) {
		topics = new ArrayList<Topic>(topics);
		// this.topics = topics;
	}

	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("spring", "Spring Essentials", "An introduction to Spring"),
			new Topic("spring-adv", "Spring Advanced", "Using Spring to develop applications"), new Topic("spring-boot",
					"Spring Boot", "This topic, on Spring Boot, which you are currently working on!")));

	public Topic gettopic(String id) {
		// yay lambdas! stream should return null if id is not found? nope,
		// noSuchElementException
		try {
			return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		} catch (NoSuchElementException e) {
			return new Topic(id, " There is no Topic topic with the name " + id, "");
		}

	}

	public void addtopic(Topic topic) {
		topics.add(topic);
	}

	private ListIterator<Topic> iterator = topics.listIterator();

	public void updatetopic(String id, Topic topic) {

		while (iterator.hasNext()) {
			Topic next = iterator.next();
			if (next.getId().equals(id)) {
				iterator.set(topic);
			}
		}
	}

	public void deletetopic(String id) {

		while (iterator.hasNext()) {
			Topic next = iterator.next();
			if (next.getId().equals(id)) {
				iterator.remove();
			}
		}
	}

}
