package pl.usa.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import pl.usa.dao.core.EntityRepository;
import pl.usa.model.core.IEntity;
import pl.usa.model.gamer.Character;
import pl.usa.model.gamer.User;
import pl.usa.model.gamer.UserProfile;
import pl.usa.model.org.BriefingTag;
import pl.usa.model.org.CharacterPersonalNote;

@Configuration
@Import(SpringConfig.class)
public class RepositoryConfiguration {

	@Autowired private SessionFactory sessionFactory;

	@Bean
	public EntityRepository<User> userRepository() {
		return createEntityRepository(User.class);
	}

	@Bean
	public EntityRepository<UserProfile> userProfileRepository() {
		return createEntityRepository(UserProfile.class);
	}

	@Bean
	public EntityRepository<Character> characterRepository() {
		return createEntityRepository(Character.class);
	}

	@Bean
	public EntityRepository<BriefingTag> BriefingTagRepository() {
		return createEntityRepository(BriefingTag.class);
	}

	@Bean
	public EntityRepository<CharacterPersonalNote> characterPersonalNoteRepository() {
		return createEntityRepository(CharacterPersonalNote.class);
	}

	private <T extends IEntity> EntityRepository<T> createEntityRepository (Class<T> clazz) {
		return new EntityRepository<T>(sessionFactory, clazz);
	}
}