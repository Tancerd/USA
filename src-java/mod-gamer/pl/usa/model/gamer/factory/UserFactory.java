package pl.usa.model.gamer.factory;

import java.util.Date;

import org.springframework.stereotype.Service;

import pl.usa.model.gamer.User;

@Service
public class UserFactory {

	public User createCommonUser() {

		User user = new User();

		user.setDateCreate(new Date());
		user.setRole("ROLE_USER");

		return user;
	}

	public void setCommonData(User user) {

		user.setDateCreate(new Date());
		user.setRole("ROLE_USER");
	}
}
