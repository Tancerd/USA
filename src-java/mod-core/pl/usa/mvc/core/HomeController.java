package pl.usa.mvc.core;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"/", "/home", "index"})
public class HomeController {

	private final static String VIEW_NAME = "index";


	@RequestMapping(method=GET)
	public String getHomePage() {
		return VIEW_NAME;
	}
}
