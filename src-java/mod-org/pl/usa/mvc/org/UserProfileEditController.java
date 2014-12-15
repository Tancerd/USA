package pl.usa.mvc.org;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.usa.dao.core.EntityRepository;
import pl.usa.dao.org.UserProfileQueries;
import pl.usa.model.gamer.UserProfile;

@Controller("orgUserProfileEditController")
@RequestMapping("org/userProfile-edit.htm")
public class UserProfileEditController {

	private static final String VIEW_NAME = "org/userProfile-edit-view";
	private static final String REDIRECT_VIEW_NAME = "redirect:userProfile-edit.htm?id=";
	private static final String ID = "id";
	private static final String COMMAND = "profile";

	@Autowired private UserProfileQueries userProfileQueries;
	@Autowired private EntityRepository<UserProfile> userProfileRepository;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping(method = GET, params = ID)
	public String initView(@RequestParam(value = ID, required = true)long id, Model model) {

		model.addAttribute(COMMAND, userProfileQueries.findById(id));

		return VIEW_NAME;
	}

	@RequestMapping(method = POST)
	public String handlePost(@ModelAttribute(COMMAND)UserProfile profile, Model model) {

		userProfileRepository.saveOrUpdate(profile);

		return REDIRECT_VIEW_NAME + profile.getId();
	}
}
