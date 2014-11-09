package pl.usa.mvc.org;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.usa.dao.org.CharacterQueries;

@Controller
@RequestMapping("org/character-list.htm")
public class CharacterListController {

	private static final String VIEW_NAME = "org/character-list-view";

	private @Autowired CharacterQueries characterQueries;


	@RequestMapping(method = GET)
	public String initView(Model model) {

		model.addAttribute("characters", characterQueries.loadAll());

		return VIEW_NAME;
	}
}
