package pl.usa.mvc.gamer;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.usa.logic.gamer.BriefingTagInterpreter;
import pl.usa.model.gamer.Character;
import pl.usa.model.gamer.User;
import pl.usa.model.org.Briefing;
import pl.usa.utils.core.WebUtil;

@Controller
@RequestMapping("gamer/character.htm")
public class CharacterController {

	private static final String VIEW_NAME = "gamer/character-view";
	private static final String REDIRECT_VIEW = "redirect:character-formular.htm";

	@Autowired private WebUtil webUtil;
	@Autowired private BriefingTagInterpreter tagInterpreter;

	@RequestMapping(method = GET)
	public String initView(Model model) {

		User user = webUtil.getLoggedUser();

		if (user.getCharacter() == null) {
			return REDIRECT_VIEW;
		}

		Character character = user.getCharacter();

		if (character.getBriefing().isReady()) {
			prepareBriefing(character.getBriefing());
		}

		model.addAttribute("character", user.getCharacter());

		return VIEW_NAME;
	}

	private void prepareBriefing(Briefing briefing) {

		String preparedGossip = tagInterpreter.interprate(briefing.getGossip());
		briefing.setGossip(preparedGossip);

		String preparedKnow = tagInterpreter.interprate(briefing.getKnow());
		briefing.setKnow(preparedKnow);

		String preparedHave = tagInterpreter.interprate(briefing.getHave());
		briefing.setHave(preparedHave);

		String preparedWant = tagInterpreter.interprate(briefing.getWant());
		briefing.setWant(preparedWant);
	}
}
