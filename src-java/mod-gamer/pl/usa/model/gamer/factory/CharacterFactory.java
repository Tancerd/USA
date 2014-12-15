package pl.usa.model.gamer.factory;

import org.springframework.stereotype.Service;

import pl.usa.model.gamer.Character;
import pl.usa.model.gamer.User;
import pl.usa.model.org.Briefing;

@Service
public class CharacterFactory {

	public Character createNewCharacter() {

		Character character = new Character();
		character.setBriefing(new Briefing());

		return character;
	}

	public void assignUserHisCharacter(Character character, User user) {

		character.setUser(user);
		character.setBriefing(new Briefing());
	}
}
