package pl.usa.mvc.gamer;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.usa.dao.core.EntityRepository;
import pl.usa.model.gamer.Character;
import pl.usa.model.gamer.User;
import pl.usa.model.gamer.factory.CharacterFactory;
import pl.usa.utils.core.WebUtil;
import pl.usa.validator.gamer.CharacterValidator;

@Controller
@RequestMapping("gamer/character-formular.htm")
public class CharacterFormularController {

	private static final String VIEW_NAME = "gamer/character-formular-view";
	private static final String REDIRECT_VIEW_NAME = "redirect:character.htm";
	private static final String REDIRECT_WRONG_VIEW_NAME = "redirect:userProfile.htm";
	private static final String COMMAND = "character";

	@Autowired private WebUtil webUtil;
	@Autowired private CharacterFactory characterFactory;
	@Autowired private EntityRepository<Character> characterRepository;
	@Autowired private CharacterValidator characterValidator;


	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		dataBinder.setValidator(characterValidator);
	}

	@RequestMapping(method = GET)
	public String initForm(Model model) {

		if (!userIsAllowed()) {
			return REDIRECT_WRONG_VIEW_NAME;
		}

		model.addAttribute(COMMAND, characterFactory.createNewCharacter());

		return VIEW_NAME;
	}

	@RequestMapping(method = POST)
	public String createObject(@ModelAttribute(COMMAND) @Validated Character character, BindingResult result) {

		if (result.hasErrors()) {
			return VIEW_NAME;
		}

		if (!userIsAllowed()) {
			return REDIRECT_WRONG_VIEW_NAME;
		}

		characterFactory.assignUserHisCharacter(character, webUtil.getLoggedUser());
		characterRepository.saveOrUpdate(character);

		return REDIRECT_VIEW_NAME;
	}

	private boolean userIsAllowed() {

		User user = webUtil.getLoggedUser();

		return !(user.getProfile() == null || user.getCharacter() != null);
	}
}
