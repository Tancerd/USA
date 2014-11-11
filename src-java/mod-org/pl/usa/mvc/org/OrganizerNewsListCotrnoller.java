package pl.usa.mvc.org;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static pl.usa.model.main.NewsType.ALL;
import static pl.usa.model.main.NewsType.valueOf;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.usa.dao.main.NewsQueries;
import pl.usa.model.main.NewsType;


@Controller
@RequestMapping({"org/news-list.htm", "org/index.htm"})
public class OrganizerNewsListCotrnoller {

	private static final String VIEW_NAME = "org/news-list-view";
	private static final String NEWS = "newsList";
	private static final String TYPE = "type";
	private static final String SELECTED_TYPE = "selectedType";
	private static final String TYPES = "types";

	@Autowired private NewsQueries newsQueries;


	@ModelAttribute(TYPES)
	public List<NewsType> newsTypes() {
		return Arrays.asList(NewsType.values());
	}

	@RequestMapping(method = GET)
	public String initNewsView(Model model) {

		model.addAttribute(NEWS, newsQueries.loadAll());
		model.addAttribute(SELECTED_TYPE, ALL);

		return VIEW_NAME;
	}

	@RequestMapping(method = GET, params = TYPE)
	public String initNewsView(@RequestParam(TYPE) String type, Model model) {

		NewsType newsType = valueOf(type);

		model.addAttribute(NEWS, newsQueries.findByType(newsType));
		model.addAttribute(SELECTED_TYPE, newsType);

		return VIEW_NAME;
	}
}
