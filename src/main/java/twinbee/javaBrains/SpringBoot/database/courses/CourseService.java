/**
 * 
 */
package twinbee.javaBrains.SpringBoot.database.courses;

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
public class CourseService {

	@Autowired
	private ICourseRepository courseRepository;

	public List<Course> getAllCourses(String topicId) {
		List<Course> retcourses = new ArrayList<Course>();

		courseRepository.findByTopicId(topicId).forEach(retcourses::add);
		return retcourses;
	}

	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}


	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.delete(id);

	}

}
