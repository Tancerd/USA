package pl.usa.mvc.main;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.usa.dao.core.EntityRepository;
import pl.usa.model.gamer.User;
import pl.usa.model.gamer.factory.UserFactory;

@Controller
@RequestMapping(value="/user-formular.htm")
public class UserFormularController {

	private static final String VIEW_NAME = "main/user-formular-view";
	private static final String REDIRECT_VIEW_NAME = "redirect:index.htm";
	private static final String COMMAND = "user";

	@Autowired private EntityRepository<User> userRepository;
	@Autowired private UserFactory userFactory;

	@RequestMapping(method=GET)
	public String initForm(Model model) {

		model.addAttribute(COMMAND, new User());

		return VIEW_NAME;
	}

	@RequestMapping(method=POST)
	public String createObject(@ModelAttribute(COMMAND) User user) {

		userFactory.setCommonData(user);
		userRepository.saveOrUpdate(user);

		return REDIRECT_VIEW_NAME;
	}
}
