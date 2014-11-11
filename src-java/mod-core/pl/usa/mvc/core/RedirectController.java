package pl.usa.mvc.core;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

	@RequestMapping(value = "/org", method = GET)
	public String orgRedirect() {
		return "redirect:index.htm";
	}

	@RequestMapping(value = "/", method = GET)
	public String mainRedirect() {
		return "redirect:index.htm";
	}
}
