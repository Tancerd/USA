package pl.usa.validator.gamer;

import static pl.usa.utils.core.ValidationMessages.EMAIL_EXISTS;
import static pl.usa.utils.core.ValidationMessages.EMAIL_WRONG_PATTERN;
import static pl.usa.utils.core.ValidationMessages.PASSWORD_NOT_THE_SAME;
import static pl.usa.utils.core.ValidationMessages.PASSWORD_TO_LONG;
import static pl.usa.utils.core.ValidationMessages.PASSWORD_TO_SHORT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.usa.dao.gamer.UserQueries;
import pl.usa.model.gamer.User;

@Service
public class UserValidator implements Validator {

	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	@Autowired private UserQueries userQueries;


	@Override
	public boolean supports(Class clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {

		User user = (User) object;

		Matcher matcher = pattern.matcher(user.getEmail());

		if (!matcher.matches()) {
			errors.rejectValue("email", "wrongPattern", EMAIL_WRONG_PATTERN);
		}
		if (user.getPassword().length() < 6) {
			errors.rejectValue("password", "toShort", PASSWORD_TO_SHORT);
		}
		if (user.getPassword().length() > 30) {
			errors.rejectValue("password", "toLong", PASSWORD_TO_LONG);
		}
		if (!user.getPassword().equals(user.getRepeatedPassword())) {
			errors.rejectValue("password", "notTheSame", PASSWORD_NOT_THE_SAME);
		}
		if (userQueries.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "exists", EMAIL_EXISTS);
		}
	}
}
