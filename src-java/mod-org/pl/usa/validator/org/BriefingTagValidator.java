package pl.usa.validator.org;

import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;
import static pl.usa.utils.core.ValidationMessages.DESCRIPTION_TO_LONG;
import static pl.usa.utils.core.ValidationMessages.EMPTY;
import static pl.usa.utils.core.ValidationMessages.IDENTIFIER_EXISTS;
import static pl.usa.utils.core.ValidationMessages.TEXT_TO_LONG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.usa.dao.org.BriefingTagQueries;
import pl.usa.model.org.BriefingTag;

@Service
public class BriefingTagValidator implements Validator {

	@Autowired private BriefingTagQueries tagQueries;


	@Override
	public boolean supports(Class clazz) {
		return BriefingTag.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {

		rejectIfEmptyOrWhitespace(errors, "description", "empty", EMPTY);
		rejectIfEmptyOrWhitespace(errors, "identifier", "empty", EMPTY);

		BriefingTag tag = (BriefingTag) object;

		if (tag.getDescription().length() > 60) {
			errors.rejectValue("description", "toLong", DESCRIPTION_TO_LONG);
		}
		if (tag.getText().length() > 1000) {
			errors.rejectValue("text", "toLong", TEXT_TO_LONG);
		}
		if (tagQueries.findOtherByIdentifier(tag.getIdentifier(), tag.getId()) != null) {
			errors.rejectValue("identifier", "exists", IDENTIFIER_EXISTS);
		}
	}

}
