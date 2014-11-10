package pl.usa.mvc.org;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.usa.dao.core.EntityQueries;
import pl.usa.dao.core.EntityRepository;
import pl.usa.factory.org.CharacterPersonalNoteFactory;
import pl.usa.model.org.CharacterPersonalNote;
import pl.usa.utils.core.WebUtil;

@Controller
@RequestMapping("org/characterPersonalNote.ltr")
public class CharacterPersonalNoteController {

	private static final String ID = "id";
	private static final String NOTE = "note";

	private static final String RESPONSE_OK = "OK";
	private static final String RESPONSE_CONFLICT = "CONFLICT";

	@Autowired private EntityRepository<CharacterPersonalNote> characterPersonalNoteRepository;
	@Autowired private EntityQueries<CharacterPersonalNote> noteQueries;
	@Autowired private CharacterPersonalNoteFactory characterPersonalNoteFactory;
	@Autowired private WebUtil webUtil;


	@RequestMapping(method = POST)
	@ResponseBody
	public String addNote(@RequestParam(value = ID, required = true) long id, @RequestParam(value = NOTE, required = true) String text) {

		CharacterPersonalNote note = characterPersonalNoteFactory.createNote(id, text);

		if (note == null) {
			return RESPONSE_CONFLICT;
		}

		characterPersonalNoteRepository.saveOrUpdate(note);

		return RESPONSE_OK;
	}

	@RequestMapping(method = POST, params = "delete")
	@ResponseBody
	public String deleteNote(@RequestParam(value = ID, required = true) long id) {

		CharacterPersonalNote note = noteQueries.findById(id);

		if (note == null || !note.getAuthor().equals(webUtil.getLoggedUser())) {
			return RESPONSE_CONFLICT;
		}

		characterPersonalNoteRepository.delete(note);

		return RESPONSE_OK;
	}

}
