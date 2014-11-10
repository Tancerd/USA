package pl.usa.mvc.org;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.usa.dao.core.EntityQueries;
import pl.usa.model.org.BriefingTag;

@Controller
@RequestMapping("org/briefingTag-list.htm")
public class BriefingTagListController {

	private static final String VIEW_NAME = "org/briefingTag-list-view";


	@Autowired private EntityQueries<BriefingTag> briefingTagQueries;


	@RequestMapping(method = GET)
	public String initView(Model model) {

		model.addAttribute("tags", briefingTagQueries.loadAll());

		return VIEW_NAME;
	}
}
