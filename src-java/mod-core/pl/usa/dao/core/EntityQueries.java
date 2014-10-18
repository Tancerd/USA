package pl.usa.dao.core;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import pl.usa.model.core.IEntity;

public class EntityQueries <T extends IEntity> {

	private SessionFactory sessionFactory;
	private Class<T> clazz;

	public EntityQueries(@Qualifier SessionFactory sessionFactory, Class<T> clazz) {
		this.sessionFactory = sessionFactory;
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
		@Transactional
	public T findById(long id) {
		return (T)sessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> loadAll() {
		return sessionFactory.getCurrentSession().createCriteria(clazz).list();
	}
}
