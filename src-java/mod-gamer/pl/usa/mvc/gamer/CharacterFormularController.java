package pl.usa.mvc.gamer;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.usa.dao.core.EntityRepository;
import pl.usa.model.gamer.Character;
import pl.usa.model.gamer.factory.CharacterFactory;
import pl.usa.utils.core.WebUtil;

@Controller
@RequestMapping("gamer/character-formular.htm")
public class CharacterFormularController {

	private static final String VIEW_NAME = "gamer/character-formular-view";
	private static final String REDIRECT_VIEW_NAME = "redirect:character.htm";
	private static final String COMMAND = "character";

	@Autowired private WebUtil webUtil;
	@Autowired private CharacterFactory characterFactory;
	@Autowired private EntityRepository<Character> characterRepository;

	@RequestMapping(method = GET)
	public String initForm(Model model) {

		model.addAttribute(COMMAND, characterFactory.createNewCharacter());

		return VIEW_NAME;
	}

	@RequestMapping(method = POST)
	public String createObject(@ModelAttribute(COMMAND) Character character) {

		characterFactory.assignUserHisCharacter(character, webUtil.getLoggedUser());
		characterRepository.saveOrUpdate(character);

		return REDIRECT_VIEW_NAME;
	}
}
