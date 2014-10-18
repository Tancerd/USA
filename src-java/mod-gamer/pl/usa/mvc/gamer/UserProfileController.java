package pl.usa.mvc.gamer;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gamer/userProfile.htm")
public class UserProfileController {

	private String VIEW_NAME = "gamer/userProfile-view";


	@RequestMapping(method=GET)
	public String initView() {
		return VIEW_NAME;
	}
}
