package pl.usa.factory.org;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.usa.dao.org.CharacterQueries;
import pl.usa.model.gamer.Character;
import pl.usa.model.gamer.User;
import pl.usa.model.org.CharacterPersonalNote;
import pl.usa.utils.core.WebUtil;

@Service
public class CharacterPersonalNoteFactory {

	@Autowired private CharacterQueries characterQueries;
	@Autowired private WebUtil webUtil;


	public CharacterPersonalNote createNote(long id, String text) {

		CharacterPersonalNote note = new CharacterPersonalNote();

		User author = webUtil.getLoggedUser();
		Character character = characterQueries.findById(id);

		if (text.isEmpty() || author == null || character == null) {
			return null;
		}

		note.setNote(text);
		note.setAuthor(author);
		note.setCharacter(character);
		note.setDateCreate(new Date());

		return note;
	}
}
