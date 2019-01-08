/**
 * 
 */
package twinbee.javaBrains.SpringBoot;

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
	public List<Topic> getAllTopics() {
		return topicService.getTopics();
	}

	@RequestMapping(method=RequestMethod.GET, value="/topics/{whichTopic}")
	public Topic getTopic(@PathVariable("whichTopic") String id) {
		return topicService.getTopic(id);
	}

	public TopicController() {
		super();
	}
	
	/**
	 * 	needs a method to convert from POST request BODY to topic
	 * somehow, this magically works with JSON
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {

//		Example POST JSON body that will make a topic
// Header Content-Type: application/json
//			    {
//				 "id": "javaee",
//				 "name": "Java EE",
//				 "description":	"Java enterprise edition"
//				}

		topicService.addTopic(topic);
	}

	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	
}
