package pl.usa.dao.org;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.usa.dao.core.EntityQueries;
import pl.usa.model.gamer.Character;

@Repository
public class CharacterQueries extends EntityQueries<Character> {

	@Autowired
	public CharacterQueries(SessionFactory sessionFactory) {

		super(sessionFactory);
		this.clazz = Character.class;
	}

	public Character findByName(String name) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Character.class)
							.add(Restrictions.eq("name", name));

		return (Character) criteria.uniqueResult();
	}

}
