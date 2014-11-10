package pl.usa.mvc.org;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.usa.dao.core.EntityRepository;
import pl.usa.dao.org.CharacterQueries;
import pl.usa.model.gamer.Character;

@Controller
@RequestMapping("org/character-edit.htm")
public class CharacterEditController {

	private static final String VIEW_NAME = "org/character-edit-view";
	private static final String REDIRECT_VIEW_NAME = "redirect:character-edit.htm?id=";
	private static final String ID = "id";
	private static final String COMMAND = "character";

	@Autowired private CharacterQueries characterQueries;
	@Autowired private EntityRepository<Character> characterRepository;


	@RequestMapping(method = GET, params = ID)
	public String initView(@RequestParam(value = ID, required = true)long id, Model model) {

		model.addAttribute(COMMAND, characterQueries.findById(id));

		return VIEW_NAME;
	}

	@RequestMapping(method = POST)
	public String handlePost(@ModelAttribute(COMMAND)Character character, Model model) {

		characterRepository.saveOrUpdate(character);

		return REDIRECT_VIEW_NAME + character.getId();
	}
}
