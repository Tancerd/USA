package pl.usa.mvc.org;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("org/tag-list.htm")
public class CharacterTagListController {

	private static final String VIEW_NAME = "org/tag-list-view";


	@RequestMapping(method = GET)
	public String initView() {
		return VIEW_NAME;
	}
}
