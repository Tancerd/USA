package pl.usa.mvc.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	private static final String VIEW_NAME = "main/login-view";


	@RequestMapping("login.htm")
	public String initView() {
		return VIEW_NAME;
	}
}
