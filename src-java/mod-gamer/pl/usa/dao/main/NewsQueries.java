package pl.usa.dao.main;

import static org.hibernate.criterion.Restrictions.eq;
import static pl.usa.model.main.NewsType.ALL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.usa.dao.core.EntityQueries;
import pl.usa.model.main.News;
import pl.usa.model.main.NewsType;

@Repository
public class NewsQueries extends EntityQueries<News> {

	@Autowired
	public NewsQueries(SessionFactory sessionFactory) {

		super(sessionFactory);
		this.clazz = News.class;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<News> findByType(NewsType type) {

		Criteria criteria;

		if (type != NewsType.ALL) {

			criteria = sessionFactory.getCurrentSession()
											.createCriteria(News.class)
											.add(Restrictions.or(eq("type", type), eq("type", ALL)));

			return criteria.list();
		}
		else {
			return loadAll();
		}
	}

}
