/**
 * 
 */
package twinbee.javaBrains.SpringBoot.database.topics;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author matthew
 *
 */
@Entity
public class Topic {

@Id	
private String id;
private String name, description;


public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

@Override
public String toString() {
	return "topic [id=" + id + ", name=" + name + ", description=" + description + "]";
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Topic() {
}

public Topic(String id, String name, String description) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
}

public Topic(String id) {
	super();
	this.id = id;
	this.name = id + " name";
	this.description = id + " description";
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

}
