/**
 * 
 */
package twinbee.javaBrains.SpringBoot.database.courses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import twinbee.javaBrains.SpringBoot.database.topics.Topic;

/**
 * @author matthew
 *
 */
@Entity
public class Course {

@Id	
private String id;
private String name, description;

@ManyToOne
private Topic topic;

public String getId() {
	return id;
}

public Topic getTopic() {
	return topic;
}

public void setTopic(Topic topic) {
	this.topic = topic;
}

public void setId(String id) {
	this.id = id;
}

@Override
public String toString() {
	return "course [id=" + id + ", name=" + name + ", description=" + description + "]";
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Course() {
}

//public Course(String id, String name, String description, Topic topic) {
//	super();
//	this.id = id;
//	this.name = name;
//	this.description = description;
//	this.topic = topic;
//}

public Course(String id, String name, String description, String topicId) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.topic = new Topic (topicId, id + " name", id + description  );
}


public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

}
