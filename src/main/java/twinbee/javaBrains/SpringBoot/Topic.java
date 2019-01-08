/**
 * 
 */
package twinbee.javaBrains.SpringBoot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matthew
 *
 */
@RestController
public class Topic {

private String id, name, description;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

@Override
public String toString() {
	return "Topic [id=" + id + ", name=" + name + ", description=" + description + "]";
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

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

}
