package pl.usa.utils.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pl.usa.dao.gamer.UserQueries;
import pl.usa.model.gamer.User;

@Service
public class WebUtil {

	@Autowired private UserQueries userQueries;


	public User getLoggedUser() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		return userQueries.getUserByEmail(email);
	}

}
