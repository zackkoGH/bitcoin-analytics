package com.gconsulting.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gconsulting.dao.ApiDao;
import com.gconsulting.model.Api;
import com.gconsulting.model.ids.FeeApiId;

/**
 * This class interacts with Hibernate session to save/delete and retrieve
 * Api objects.
 *
 * @author <a href="mailto:gsit80@gmail.com">Giovanni Silvestri</a>
 */
@Repository("apiDao")
@SuppressWarnings("unchecked")
public class ApiDaoHibernate extends GenericDaoHibernate<Api, FeeApiId>
		implements ApiDao {

	public ApiDaoHibernate(Class<Api> persistentClass) {
		super(persistentClass);
	}

	/**
	 * {@inheritDoc}
	 */
	public Api getApiById(FeeApiId id) {
		
		return (Api) getSession().get(FeeApiId.class, id);
	}

	/**
	 * {@inheritDoc}
	 */
    public List<Api> getAll() {
		return (List<Api>) getSession().createQuery(
				"from Api").list();
    }

	/**
	 * {@inheritDoc}
	 */
    public void create(Api api) {
    	getSession().save(api);
    }

	/**
	 * {@inheritDoc}
	 */
    public void update(Api api) {
    	getSession().update(api);
    }

	/**
	 * {@inheritDoc}
	 */
    public void delete(Api api) {
    	getSession().delete(api);
    }
}