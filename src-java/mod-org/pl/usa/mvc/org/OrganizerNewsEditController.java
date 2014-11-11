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
import pl.usa.dao.main.NewsQueries;
import pl.usa.model.main.News;
import pl.usa.model.org.factory.NewsFactory;

@Controller
public class OrganizerNewsEditController {

	private static final String VIEW_NAME = "org/news-edit-view";
	private static final String REDIRECT_VIEW_NAME = "redirect:news-edit.htm?id=";
	private static final String REDIRECT_WRONG_VIEW_NAME = "redirect:news-edit.htm";
	private static final String ID = "id";
	private static final String NO_ID = "!id";

	private static final String COMMAND = "news";

	@Autowired private EntityRepository<News> newsRepository;
	@Autowired private NewsQueries newsQueries;
	@Autowired private NewsFactory newsFactory;


	@RequestMapping(method = GET, params = NO_ID)
	public String initNewView(Model model) {

		model.addAttribute(COMMAND, new News());

		return VIEW_NAME;
	}

	@RequestMapping(method = GET, params = ID)
	public String initView(@RequestParam(ID) long id, Model model) {

		News news = newsQueries.findById(id);

		if (news == null) {
			return REDIRECT_WRONG_VIEW_NAME;
		}

		model.addAttribute(COMMAND, news);

		return VIEW_NAME;
	}

	@RequestMapping(method = POST)
	public String handleNewPost(@ModelAttribute(COMMAND) News news) {

		newsFactory.prepareToPersist(news);

		newsRepository.saveOrUpdate(news);

		return REDIRECT_VIEW_NAME + news.getId();
	}

	
}
