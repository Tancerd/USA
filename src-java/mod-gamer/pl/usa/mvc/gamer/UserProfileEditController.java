package pl.usa.mvc.gamer;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.usa.dao.core.EntityRepository;
import pl.usa.model.gamer.User;
import pl.usa.model.gamer.UserProfile;
import pl.usa.model.gamer.factory.ProfileFactory;
import pl.usa.utils.core.WebUtil;
import pl.usa.validator.gamer.UserProfileValidator;

@Controller
@RequestMapping("gamer/userProfile-edit.htm")
public class UserProfileEditController {

	private static final String VIEW_NAME = "gamer/userProfile-edit-view";
	private static final String REDIRECT_VIEW = "redirect:userProfile.htm";
	private static final String PROFILE = "profile";

	@Autowired private WebUtil webUtil;
	@Autowired private ProfileFactory profileFactory;
	@Autowired private EntityRepository<UserProfile> userProfileRepository;
	@Autowired private UserProfileValidator userProfileValidator;


	@InitBinder
	protected void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));

		binder.setValidator(userProfileValidator);
	}

	@RequestMapping(method = GET)
	public String initView(Model model) {

		User user = webUtil.getLoggedUser();

		if (user.getProfile() != null) {
			model.addAttribute(PROFILE, user.getProfile());
		}
		else {
			model.addAttribute(PROFILE, profileFactory.createNewProfile());
		}

		return VIEW_NAME;
	}

	@RequestMapping(method = POST)
	public String saveProfile(Model model, @ModelAttribute(value = PROFILE) @Validated UserProfile profile, BindingResult bindingResult) {

		if(bindingResult.hasErrors()){
			return VIEW_NAME;
		}

		profileFactory.assignUserHisProfile(webUtil.getLoggedUser(), profile);
		userProfileRepository.saveOrUpdate(profile);

		model.addAttribute(PROFILE, profile);

		return REDIRECT_VIEW;
	}
}
