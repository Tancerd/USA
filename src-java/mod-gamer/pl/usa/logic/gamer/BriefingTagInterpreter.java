package pl.usa.logic.gamer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.usa.dao.org.BriefingTagQueries;
import pl.usa.model.org.BriefingTag;

@Service
public class BriefingTagInterpreter {

	@Autowired private BriefingTagQueries briefingTagQueries;


	public String interprate(String text) {

		List<BriefingTag> availableTags = briefingTagQueries.loadAll();

		for (BriefingTag tag : availableTags) {

			String preparedTag = formedTag(tag);

			text = text.replace(preparedTag, tag.getText());
		}

		return text;
	}


	private String formedTag(BriefingTag tag) {

		return "[" + tag.getIdentifier() + "];";
	}
}
