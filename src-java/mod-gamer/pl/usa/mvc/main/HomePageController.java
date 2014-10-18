package pl.usa.mvc.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.usa.dao.core.EntityQueries;
import pl.usa.model.main.News;

@Controller
public class HomePageController {

	private static final String NEWS_VIEW = "main/news-list-view";
	private static final String ABOUT_VIEW = "main/about-view";
	private static final String CONTACT_VIEW = "main/contact-view";
	private static final String NEWS_LIST = "newsList";

	@Autowired private EntityQueries<News> newsQueries;


	@RequestMapping({"/index.htm", "/", "/news.htm"})
	public String initNewsView(Model model) {

		model.addAttribute(NEWS_LIST, newsQueries.loadAll());

		return NEWS_VIEW;
	}

	@RequestMapping({"/about.htm"})
	public String initAboutView() {
		return ABOUT_VIEW;
	}

	@RequestMapping({"/contact.htm"})
	public String initContactView() {
		return CONTACT_VIEW;
	}
}
