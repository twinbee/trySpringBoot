/**
 * 
 */
package twinbee.javaBrains.SpringBoot.database.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import twinbee.javaBrains.SpringBoot.database.topics.Topic;
import twinbee.javaBrains.SpringBoot.database.topics.TopicService;

/**
 * @author matthew
 *
 */

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private TopicService topicService;

	/**
	 * list out all of the existing courses
	 */
	@RequestMapping(method=RequestMethod.GET, value="/topics/{topicId}/courses")
	public List<Course> getAllcourses(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}

	@RequestMapping(method=RequestMethod.GET, value="/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable("courseId") String id) {
		return courseService.getCourse(id);
	}

	
	/**
	 * 	needs a method to convert from POST request BODY to course
	 * somehow, this magically works with JSON
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		
		Topic topicLookedUp = topicService.getTopic(topicId);
		if (topicLookedUp == null)
		{
			topicLookedUp = new Topic(topicId);
		}
		
		topicService.addTopic(topicLookedUp);
		
		//FIXME
		//course.setTopic(new Topic(topicId, "created in addCourse()", ""));
				
		courseService.addCourse(course);
	}

	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId) {
		//FIXME
		
		if (course.getTopic() == null) course.setTopic(new Topic(topicId, "created in updateCourse()", ""));

		courseService.updateCourse(course);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}")
	public void deletecourse(@PathVariable String courseId) {
		courseService.deleteCourse(courseId);
	}
	
}
