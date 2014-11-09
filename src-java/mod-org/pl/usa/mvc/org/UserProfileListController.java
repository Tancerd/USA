package pl.usa.mvc.org;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.usa.dao.org.UserProfileQueries;

@Controller
@RequestMapping("org/user-list.htm")
public class UserProfileListController {

	private static final String VIEW_NAME = "org/userProfile-list-view";

	@Autowired private UserProfileQueries userProfileQueries;


	@RequestMapping(method = GET)
	public String initView(Model model) {

		model.addAttribute("profiles", userProfileQueries.getCommonUsersProfiles());

		return VIEW_NAME;
	}
}
