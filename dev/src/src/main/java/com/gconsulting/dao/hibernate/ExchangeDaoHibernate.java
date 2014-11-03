package com.gconsulting.dao.hibernate;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.gconsulting.dao.ExchangeDao;
import com.gconsulting.model.API;
import com.gconsulting.model.Exchange;
import com.gconsulting.model.Fee;
import com.gconsulting.model.FeeApiType;
import com.gconsulting.model.Market;
import com.gconsulting.model.ids.FeeApiId;
import com.gconsulting.model.ids.FeeApiTypeId;

/**
 * This class interacts with Hibernate session to save/delete and retrieve
 * Exchange objects.
 *
 * @author <a href="mailto:gsit80@gmail.com">Giovanni Silvestri</a>
 */
@Repository("exchangeDao")
@SuppressWarnings("unchecked")
public class ExchangeDaoHibernate
		implements ExchangeDao {

	/**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(ExchangeDaoHibernate.class);
    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public Session getSession() throws HibernateException {
    	
        Session sess = getSessionFactory().getCurrentSession();
        if (sess == null) {
            sess = getSessionFactory().openSession();
        }
        return sess;
    }

    @Autowired
    @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ExchangeDaoHibernate() {
	}

	/**
	 * {@inheritDoc}
	 */
	public Exchange getExchangeByCode(String code) {
		
		Query qry = getSession().createQuery(
				"from Exchange e where e.code='" + code + "'");
		if (qry.list() != null) {
			if (qry.list().size() > 0) {
				return (Exchange) qry.list().get(0);
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
    public List<Exchange> getAllExchange() {
		return (List<Exchange>) getSession().createCriteria(Exchange.class).list();
//		return (List<Exchange>) getSession().createQuery(
//				"from Exchange").list();
    }

	/**
	 * {@inheritDoc}
	 */
    public void create(Exchange exchange) {
    	getSession().save(exchange);
    }

	/**
	 * {@inheritDoc}
	 */
    public void update(Exchange exchange) {
    	getSession().update(exchange);
    }

	/**
	 * {@inheritDoc}
	 */
    public void delete(Exchange exchange) {
    	getSession().delete(exchange);
    }

	/**
	 * {@inheritDoc}
	 */
	public Market getMarketByCode(String code) {
		
		Query qry = getSession().createQuery(
				"from Market m where m.code='" + code + "'");
		if (qry.list() != null) {
			if (qry.list().size() > 0) {
				return (Market) qry.list().get(0);
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
    public List<Market> getAllMarket() {
		return (List<Market>) getSession().createQuery(
				"from Market").list();
    }

	/**
	 * {@inheritDoc}
	 */
    public void create(Market market) {
    	getSession().save(market);
    }

	/**
	 * {@inheritDoc}
	 */
    public void update(Market market) {
    	getSession().update(market);
    }

	/**
	 * {@inheritDoc}
	 */
    public void delete(Market market) {
    	getSession().delete(market);
    }

	/**
	 * {@inheritDoc}
	 */
	public API getApiById(FeeApiId id) {
		return (API) getSession().get(API.class, id);
	}

	/**
	 * {@inheritDoc}
	 */
    public List<API> getAllApi() {
		return (List<API>) getSession().createQuery(
				"from API").list();
    }

	/**
	 * {@inheritDoc}
	 */
    public void create(API api) {
    	getSession().save(api);
    }

	/**
	 * {@inheritDoc}
	 */
    public void update(API api) {
    	getSession().update(api);
    }

	/**
	 * {@inheritDoc}
	 */
    public void delete(API api) {
    	getSession().delete(api);
    }

	/**
	 * {@inheritDoc}
	 */
	public Fee getFeeById(FeeApiId id) {
		return (Fee) getSession().get(Fee.class, id);
	}

	/**
	 * {@inheritDoc}
	 */
    public List<Fee> getAllFee() {
		return (List<Fee>) getSession().createQuery(
				"from Fee").list();
    }

	/**
	 * {@inheritDoc}
	 */
    public void create(Fee fee) {
    	getSession().save(fee);
    }

	/**
	 * {@inheritDoc}
	 */
    public void update(Fee fee) {
    	getSession().update(fee);
    }

	/**
	 * {@inheritDoc}
	 */
    public void delete(Fee fee) {
    	getSession().delete(fee);
    }

	/**
	 * {@inheritDoc}
	 */
    public FeeApiType getTypeById(FeeApiTypeId id){
		return (FeeApiType) getSession().get(FeeApiType.class, id);    	
    }

	/**
	 * {@inheritDoc}
	 */
    public List<FeeApiType> getAllType(){
		return (List<FeeApiType>) getSession().createQuery(
				"from FeeApiType").list();    	
    }

	/**
	 * {@inheritDoc}
	 */
    public void create(FeeApiType type) {
    	getSession().save(type);    	
    }

	/**
	 * {@inheritDoc}
	 */
    public void update(FeeApiType type) {
    	getSession().update(type);    	
    }

	/**
	 * {@inheritDoc}
	 */
    public void delete(FeeApiType type) {
    	getSession().delete(type);    	
    }
}
