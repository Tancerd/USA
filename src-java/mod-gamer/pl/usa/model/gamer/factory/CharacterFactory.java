package pl.usa.model.gamer.factory;

import org.springframework.stereotype.Service;

import pl.usa.model.gamer.Character;
import pl.usa.model.gamer.User;

@Service
public class CharacterFactory {

	public Character createNewCharacter() {

		return new Character();
	}

	public void assignUserHisCharacter(Character character, User user) {

		character.setUser(user);
	}
}
