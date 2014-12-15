package pl.usa.validator.gamer;

import static pl.usa.utils.core.ValidationMessages.LASTNAME_TO_LONG;
import static pl.usa.utils.core.ValidationMessages.LASTNAME_TO_SHORT;
import static pl.usa.utils.core.ValidationMessages.NAME_TO_LONG;
import static pl.usa.utils.core.ValidationMessages.NAME_TO_SHORT;
import static pl.usa.utils.core.ValidationMessages.PAGE_TO_LONG;
import static pl.usa.utils.core.ValidationMessages.PHONENUMBER_TO_LONG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.usa.dao.core.EntityQueries;
import pl.usa.model.gamer.UserProfile;

@Service
public class UserProfileValidator implements Validator {

	@Autowired private EntityQueries<UserProfile> userProfileQueries;


	@Override
	public boolean supports(Class clazz) {
		return UserProfile.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {

		UserProfile profile = (UserProfile) object;

		if (profile.getName().length() < 2) {
			errors.rejectValue("name", "toShort", NAME_TO_SHORT);
		}
		if (profile.getName().length() > 30) {
			errors.rejectValue("name", "toLong", NAME_TO_LONG);
		}
		if (profile.getLastname().length() < 2) {
			errors.rejectValue("lastname", "toShort", LASTNAME_TO_SHORT);
		}
		if (profile.getLastname().length() > 40) {
			errors.rejectValue("lastname", "toLong", LASTNAME_TO_LONG);
		}
		if (profile.getNick().length() < 2) {
			errors.rejectValue("nick", "toShort", NAME_TO_SHORT);
		}
		if (profile.getNick().length() > 40) {
			errors.rejectValue("nick", "toLong", NAME_TO_LONG);
		}
		if (profile.getPhoneNumber().length() > 25) {
			errors.rejectValue("phoneNumber", "toLong", PHONENUMBER_TO_LONG);
		}
		if (profile.getPrivatePageUrl().length() > 30) {
			errors.rejectValue("privatePageUrl", "toLong", PAGE_TO_LONG);
		}
	}
}
