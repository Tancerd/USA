package pl.usa.mvc.org;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.usa.dao.core.EntityQueries;
import pl.usa.dao.core.EntityRepository;
import pl.usa.model.org.BriefingTag;

@Controller
@RequestMapping("org/briefingTag-edit.htm")
public class BriefingTagEditController {

	private static final String VIEW_NAME = "org/briefingTag-edit-view";
	private static final String REDIRECT_VIEW_NAME = "redirect:briefingTag-edit.htm?id=";
	private static final String REDIRECT_WRONG_VIEW_NAME = "redirect:briefingTag-edit.htm";
	private static final String ID = "id";
	private static final String NO_ID = "!id";

	private static final String COMMAND = "tag";

	@Autowired private EntityRepository<BriefingTag> briefingTagRepository;
	@Autowired private EntityQueries<BriefingTag> briefingTagEntityQueries;


	@RequestMapping(method = GET, params = NO_ID)
	public String initNewView(Model model) {

		model.addAttribute(COMMAND, new BriefingTag());

		return VIEW_NAME;
	}

	@RequestMapping(method = GET, params = ID)
	public String initView(@RequestParam(ID) long id, Model model) {

		BriefingTag tag = briefingTagEntityQueries.findById(id);

		if (tag == null) {
			return REDIRECT_WRONG_VIEW_NAME;
		}

		model.addAttribute(COMMAND, tag);

		return VIEW_NAME;
	}

	@RequestMapping(method = POST)
	public String handleNewPost(@ModelAttribute(COMMAND) BriefingTag tag) {

		briefingTagRepository.saveOrUpdate(tag);

		return REDIRECT_VIEW_NAME + tag.getId();
	}

}
