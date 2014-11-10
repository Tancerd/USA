package pl.usa.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import pl.usa.dao.core.EntityQueries;
import pl.usa.model.core.IEntity;
import pl.usa.model.gamer.User;
import pl.usa.model.main.News;
import pl.usa.model.org.BriefingTag;
import pl.usa.model.org.CharacterPersonalNote;

@Configuration
@Import(SpringConfig.class)
public class QueriesConfiguration {

	@Autowired private SessionFactory sessionFactory;

	@Bean
	public EntityQueries<User> userQueries() {
		return createEntityQueries(User.class);
	}

	@Bean
	public EntityQueries<News> newsQueries() {
		return createEntityQueries(News.class);
	}

	@Bean
	public EntityQueries<BriefingTag> briefingTagQueries() {
		return createEntityQueries(BriefingTag.class);
	}

	@Bean
	public EntityQueries<CharacterPersonalNote> characterPersonalNote() {
		return createEntityQueries(CharacterPersonalNote.class);
	}

	private <T extends IEntity> EntityQueries<T> createEntityQueries (Class<T> clazz) {
		return new EntityQueries<T>(sessionFactory, clazz);
	}
}
