package pl.usa.mvc.org;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.usa.dao.core.EntityRepository;
import pl.usa.dao.main.NewsQueries;
import pl.usa.model.main.News;
import pl.usa.model.main.NewsType;
import pl.usa.model.org.factory.NewsFactory;

@Controller
@RequestMapping("org/news-edit.htm")
public class OrganizerNewsEditController {

	private static final String VIEW_NAME = "org/news-edit-view";
	private static final String REDIRECT_VIEW_NAME = "redirect:news-edit.htm?id=";
	private static final String REDIRECT_WRONG_VIEW_NAME = "redirect:news-edit.htm";
	private static final String ID = "id";
	private static final String NO_ID = "!id";
	private static final String TYPES = "types";

	private static final String COMMAND = "news";
	private static final String RESPONSE_OK = "OK";
	private static final String RESPONSE_CONFLICT = "CONFLICT";

	@Autowired private EntityRepository<News> newsRepository;
	@Autowired private NewsQueries newsQueries;
	@Autowired private NewsFactory newsFactory;


	@ModelAttribute(TYPES)
	public List<NewsType> newsTypes() {
		return Arrays.asList(NewsType.values());
	}

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

	@RequestMapping(method = POST, params = "delete")
	@ResponseBody
	public String deleteNews(@RequestParam(value = ID, required = true) long id) {

		News news = newsQueries.findById(id);

		if (news == null) {
			return RESPONSE_CONFLICT;
		}

		newsRepository.delete(news);

		return RESPONSE_OK;
	}
}
