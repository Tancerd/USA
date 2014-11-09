package pl.usa.mvc.org;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.usa.dao.org.UserProfileQueries;

@Controller("orgUserProfileEditController")
@RequestMapping("org/userProfile-edit.htm")
public class UserProfileEditController {

	private static final String VIEW_NAME = "org/userProfile-edit-view";
	private static final String ID = "id";

	@Autowired private UserProfileQueries userProfileQueries;


	@RequestMapping(method = GET, params = ID)
	public String initView(@RequestParam(value = ID, required = true)long id, Model model) {

		model.addAttribute("profile", userProfileQueries.findById(id));

		return VIEW_NAME;
	}
}
