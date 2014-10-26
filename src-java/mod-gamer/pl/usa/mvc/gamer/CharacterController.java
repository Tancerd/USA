package pl.usa.mvc.gamer;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.usa.model.gamer.User;
import pl.usa.utils.core.WebUtil;

@Controller
@RequestMapping("gamer/character.htm")
public class CharacterController {

	private static final String VIEW_NAME = "gamer/character-view";
	private static final String REDIRECT_VIEW = "redirect:character-formular.htm";

	@Autowired private WebUtil webUtil;

	@RequestMapping(method = GET)
	public String initView(Model model) {

		User user = webUtil.getLoggedUser();

		if (user.getCharacter() == null) {
			return REDIRECT_VIEW;
		}

		model.addAttribute("character", user.getCharacter());

		return VIEW_NAME;
	}
}
