package pl.usa.dao.org;

import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.usa.dao.core.EntityQueries;
import pl.usa.model.gamer.UserProfile;

@Repository
public class UserProfileQueries extends EntityQueries<UserProfile> {

	@Autowired
	public UserProfileQueries(SessionFactory sessionFactory) {

		super(sessionFactory);
		this.clazz = UserProfile.class;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<UserProfile> getCommonUsersProfiles() {

		Criteria criteria = sessionFactory.getCurrentSession()
													.createCriteria(UserProfile.class)
													.createAlias("user", "user")
													.add(eq("user.role", "ROLE_USER"));

		return criteria.list();
	}

}
