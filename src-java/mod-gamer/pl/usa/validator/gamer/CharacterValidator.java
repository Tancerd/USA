package pl.usa.validator.gamer;

import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;
import static pl.usa.utils.core.ValidationMessages.CHARACTER_NAME_TO_LONG;
import static pl.usa.utils.core.ValidationMessages.EMPTY;
import static pl.usa.utils.core.ValidationMessages.NAME_EXISTS;
import static pl.usa.utils.core.ValidationMessages.STORY_TO_LONG;
import static pl.usa.utils.core.ValidationMessages.STORY_TO_SHORT;
import static pl.usa.utils.core.ValidationMessages.TO_LOW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.usa.dao.org.CharacterQueries;
import pl.usa.model.gamer.Character;

@Service
public class CharacterValidator implements Validator {

	@Autowired private CharacterQueries characterQueries;


	@Override
	public boolean supports(Class clazz) {
		return Character.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {

		rejectIfEmptyOrWhitespace(errors, "name", "empty", EMPTY);

		Character character = (Character) object;

		if (character.getAge() < 1) {
			errors.rejectValue("age", "toLow", TO_LOW);
		}
		if (character.getStory().length() < 30) {
			errors.rejectValue("story", "toShort", STORY_TO_SHORT);
		}
		if (character.getStory().length() > 700) {
			errors.rejectValue("story", "toLong", STORY_TO_LONG);
		}
		if (character.getName().length() > 50) {
			errors.rejectValue("name", "toLong", CHARACTER_NAME_TO_LONG);
		}
		if (characterQueries.findByName(character.getName()) != null) {
			errors.rejectValue("name", "exists", NAME_EXISTS);
		}
	}
	
}