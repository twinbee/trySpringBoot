/**
 * 
 */
package twinbee.javaBrains.SpringBoot.database.topics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matthew
 *
 */

//TODO replace literal default data with a DB access
@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	/**
	 * list out all of the existing topics
	 */
	@RequestMapping(method=RequestMethod.GET, value="/topics")
	public List<Topic> getAlltopics() {
		return topicService.getAllTopics();
	}

	@RequestMapping(method=RequestMethod.GET, value="/topics/{whichtopic}")
	public Topic gettopic(@PathVariable("whichtopic") String id) {
		return topicService.getTopic(id);
	}

	
	//{{"id":"spring","name":"Spring Essentials","description":"An introduction to Spring"},{"id":"spring-adv","name":"Spring Advanced","description":"Using Spring to develop applications"},{"id":"spring-boot","name":"Spring Boot","description":"This topic, on Spring Boot, which you are currently working on!"}}
	/**
	 * 	needs a method to convert from POST request BODY to topic
	 * somehow, this magically works with JSON
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addtopic(@RequestBody Topic topic) {

		topicService.addTopic(topic);
	}

	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updatetopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deletetopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	
}
