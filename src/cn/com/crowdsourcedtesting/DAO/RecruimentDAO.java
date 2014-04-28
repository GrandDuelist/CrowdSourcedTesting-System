package cn.com.crowdsourcedtesting.DAO;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.crowdsourcedtesting.bean.Recruiment;

/**
 * A data access object (DAO) providing persistence and search support for
 * Recruiment entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.com.crowdsourcedtesting.bean.Recruiment
 * @author MyEclipse Persistence Tools
 */

public class RecruimentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RecruimentDAO.class);
	// property constants
	public static final String ACTIVITY_NAME = "activityName";
	public static final String ONLINE = "online";
	public static final String CONTENT = "content";
	public static final String BRIEF = "brief";
	public static final String COMPANY = "company";
	public static final String PLACE = "place";
	public static final String RECRUIMENT_TYPE = "recruimentType";

	public void save(Recruiment transientInstance) {
		log.debug("saving Recruiment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Recruiment persistentInstance) {
		log.debug("deleting Recruiment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Recruiment findById(java.lang.Integer id) {
		log.debug("getting Recruiment instance with id: " + id);
		try {
			Recruiment instance = (Recruiment) getSession().get(
					"cn.com.crowdsourcedtesting.DAO.Recruiment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Recruiment instance) {
		log.debug("finding Recruiment instance by example");
		try {
			List results = getSession()
					.createCriteria("cn.com.crowdsourcedtesting.DAO.Recruiment")
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
		log.debug("finding Recruiment instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Recruiment as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByActivityName(Object activityName) {
		return findByProperty(ACTIVITY_NAME, activityName);
	}

	public List findByOnline(Object online) {
		return findByProperty(ONLINE, online);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByBrief(Object brief) {
		return findByProperty(BRIEF, brief);
	}

	public List findByCompany(Object company) {
		return findByProperty(COMPANY, company);
	}

	public List findByPlace(Object place) {
		return findByProperty(PLACE, place);
	}

	public List findByRecruimentType(Object recruimentType) {
		return findByProperty(RECRUIMENT_TYPE, recruimentType);
	}

	public List findAll() {
		log.debug("finding all Recruiment instances");
		try {
			String queryString = "from Recruiment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Recruiment merge(Recruiment detachedInstance) {
		log.debug("merging Recruiment instance");
		try {
			Recruiment result = (Recruiment) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Recruiment instance) {
		log.debug("attaching dirty Recruiment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Recruiment instance) {
		log.debug("attaching clean Recruiment instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}