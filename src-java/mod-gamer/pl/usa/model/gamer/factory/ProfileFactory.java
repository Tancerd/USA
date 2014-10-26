package pl.usa.model.gamer.factory;

import org.springframework.stereotype.Service;

import pl.usa.model.gamer.User;
import pl.usa.model.gamer.UserProfile;

@Service
public class ProfileFactory {

	public UserProfile createNewProfile() {

		UserProfile userProfile = new UserProfile();

		return userProfile;
	}

	public void assignUserHisProfile(User user, UserProfile profile) {

		profile.setUser(user);

		if (user.getProfile() != null) {
			profile.setId(user.getProfile().getId());
		}

		user.setProfile(profile);
	}
}
