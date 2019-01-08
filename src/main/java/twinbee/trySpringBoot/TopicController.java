/**
 * 
 */
package twinbee.trySpringBoot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	 * 
	 */
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getTopics();
	}

	@RequestMapping("/topics/{whichTopic}")
	public Topic getTopic(@PathVariable("whichTopic") String id) {
		return topicService.getTopic(id);
	}

	public TopicController() {
		super();
	}

}
