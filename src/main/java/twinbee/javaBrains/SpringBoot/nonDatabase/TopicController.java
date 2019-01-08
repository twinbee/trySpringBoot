package twinbee.javaBrains.SpringBoot.nonDatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import twinbee.javaBrains.SpringBoot.nonDatabase.Topic;
import twinbee.javaBrains.SpringBoot.nonDatabase.TopicService;

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
		return topicService.gettopics();
	}

	@RequestMapping(method=RequestMethod.GET, value="/topics/{whichtopic}")
	public Topic gettopic(@PathVariable("whichtopic") String id) {
		return topicService.gettopic(id);
	}

	public TopicController() {
		super();
	}
	
	/**
	 * 	needs a method to convert from POST request BODY to topic
	 * somehow, this magically works with JSON
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addtopic(@RequestBody Topic topic) {

//		Example POST JSON body that will make a topic
// Header Content-Type: application/json
//			    {
//				 "id": "javaee",
//				 "name": "Java EE",
//				 "description":	"Java enterprise edition"
//				}

		topicService.addtopic(topic);
	}

	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updatetopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updatetopic(id, topic);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deletetopic(@PathVariable String id) {
		topicService.deletetopic(id);
	}
	
}
