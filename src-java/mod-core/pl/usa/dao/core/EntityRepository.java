package pl.usa.dao.core;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import pl.usa.model.core.IEntity;

@Transactional
public class EntityRepository <T extends IEntity> {

	private SessionFactory sessionFactory;

	public EntityRepository(@Qualifier SessionFactory sessionFactory, Class<T> clazz) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(T entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@Transactional
	public void saveOrUpdateAll(List<T> entities) {
		new UnsupportedOperationException("Not implemented yet");
	}

	@Transactional
	public void delete (T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

}
