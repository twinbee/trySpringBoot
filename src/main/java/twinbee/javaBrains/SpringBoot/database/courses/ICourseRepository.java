package twinbee.javaBrains.SpringBoot.database.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// this is a magical interface. Spring automatically implements some of these methods if you name them correctly
public interface ICourseRepository extends CrudRepository<Course, String> {

	/// ^^^ this is magically implemented by Spring Boot ^^^

	//name of the method is important here, in order 
	  //to give Spring JPA the right idea on how to auto-wire / implement the method
	// find - 
	// by - filter by a condition
	// name - matches the object property in which you are interested
	// TopicId 
	public List <Course> findByName(String name);
	public List <Course> findByDescription(String description);
	public List <Course> findByTopicId(String topicId);
	/// ^^^ this is magically implemented by Spring Boot ^^^
	
}
