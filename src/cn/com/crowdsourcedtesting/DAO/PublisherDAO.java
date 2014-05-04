package cn.com.crowdsourcedtesting.DAO;

import cn.com.crowdsourcedtesting.base.BaseHibernateDAO;
import cn.com.crowdsourcedtesting.bean.Publisher;


import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Publisher entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.com.crowdsourcedtesting.bean.Publisher
 * @author MyEclipse Persistence Tools
 */

public class PublisherDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PublisherDAO.class);
	// property constants
	public static final String PUBLISHER_NAME = "publisherName";
	public static final String PUBLISHER_LOG_EMAIL = "publisherLogEmail";
	public static final String PUBLISHER_PASSWORD = "publisherPassword";
	public static final String PUBLISHER_PHOTO = "publisherPhoto";
	public static final String PUBLISHER_CREDIT = "publisherCredit";
	public static final String PUBLISHER_AUTHORITY = "publisherAuthority";
	public static final String PUBLISHER_COMPANY = "publisherCompany";
	public static final String PUBLISHER_TYPE = "publisherType";
	public static final String PUBLISHER_CONNECT_EMAIL = "publisherConnectEmail";

	public void save(Publisher transientInstance) {
		log.debug("saving Publisher instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Publisher persistentInstance) {
		log.debug("deleting Publisher instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Publisher findById(java.lang.Integer id) {
		log.debug("getting Publisher instance with id: " + id);
		try {
			Publisher instance = (Publisher) getSession().get(
					"cn.com.crowdsourcedtesting.bean.Publisher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Publisher instance) {
		log.debug("finding Publisher instance by example");
		try {
			List results = getSession()
					.createCriteria("cn.com.crowdsourcedtesting.DAO.Publisher")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Publisher instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Publisher as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPublisherName(Object publisherName) {
		return findByProperty(PUBLISHER_NAME, publisherName);
	}

	public List findByPublisherLogEmail(Object publisherLogEmail) {
		return findByProperty(PUBLISHER_LOG_EMAIL, publisherLogEmail);
	}

	public List findByPublisherPassword(Object publisherPassword) {
		return findByProperty(PUBLISHER_PASSWORD, publisherPassword);
	}

	public List findByPublisherPhoto(Object publisherPhoto) {
		return findByProperty(PUBLISHER_PHOTO, publisherPhoto);
	}

	public List findByPublisherCredit(Object publisherCredit) {
		return findByProperty(PUBLISHER_CREDIT, publisherCredit);
	}

	public List findByPublisherAuthority(Object publisherAuthority) {
		return findByProperty(PUBLISHER_AUTHORITY, publisherAuthority);
	}

	public List findByPublisherCompany(Object publisherCompany) {
		return findByProperty(PUBLISHER_COMPANY, publisherCompany);
	}

	public List findByPublisherType(Object publisherType) {
		return findByProperty(PUBLISHER_TYPE, publisherType);
	}

	public List findByPublisherConnectEmail(Object publisherConnectEmail) {
		return findByProperty(PUBLISHER_CONNECT_EMAIL, publisherConnectEmail);
	}

	public List findAll() {
		log.debug("finding all Publisher instances");
		try {
			String queryString = "from Publisher";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Publisher merge(Publisher detachedInstance) {
		log.debug("merging Publisher instance");
		try {
			Publisher result = (Publisher) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Publisher instance) {
		log.debug("attaching dirty Publisher instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Publisher instance) {
		log.debug("attaching clean Publisher instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public Publisher isPublisher(String email, String password) {
		// TODO Auto-generated method stub

		Publisher publisher=null;
		
		List<Publisher>publishers=(List<Publisher>)this.findByProperty(PUBLISHER_LOG_EMAIL,email);
		
	    if(publishers!=null&&publishers.size()!=0)
	    {
	    	publisher = publishers.get(0);
	    	if(!publisher.getPublisherPassword().equals(password))
	    	{
	    		publisher=null;
	    	}
	    }
	    
	   
		
		return publisher;
	}
}