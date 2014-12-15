package pl.usa.dao.gamer;

import static org.hibernate.criterion.Restrictions.eq;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.usa.dao.core.EntityQueries;
import pl.usa.model.gamer.User;

@Repository
public class UserQueries extends EntityQueries<User> {

	@Autowired
	public UserQueries(SessionFactory sessionFactory) {

		super(sessionFactory);
		this.clazz = User.class;
	}

	@Transactional
	public User findByEmail(String email) {

		Criteria criteria = sessionFactory.getCurrentSession()
													.createCriteria(User.class)
													.add(eq("email", email));

		return (User) criteria.uniqueResult();
	}

}
