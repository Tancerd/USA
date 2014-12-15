package pl.usa.dao.org;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.usa.dao.core.EntityQueries;
import pl.usa.model.org.BriefingTag;

@Repository
public class BriefingTagQueries extends EntityQueries<BriefingTag> {

	@Autowired
	public BriefingTagQueries(SessionFactory sessionFactory) {

		super(sessionFactory);
		this.clazz = BriefingTag.class;
	}

	public BriefingTag findByIdentifier(String identifier) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BriefingTag.class)
							.add(Restrictions.eq("identifier", identifier));

		return (BriefingTag) criteria.uniqueResult();
	}

	public BriefingTag findOtherByIdentifier(String identifier, long owner) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BriefingTag.class)
							.add(Restrictions.eq("identifier", identifier))
							.add(Restrictions.ne("id", owner));

		return (BriefingTag) criteria.uniqueResult();
	}
}
