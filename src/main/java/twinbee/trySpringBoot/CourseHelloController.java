/**
 * 
 */
package twinbee.trySpringBoot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matthew
 *
 */
@RestController
public class CourseHelloController {

	/**
	 * 
	 */
	@RequestMapping
	public String helloResponse() {
     return "Hi There!";
	}

}
