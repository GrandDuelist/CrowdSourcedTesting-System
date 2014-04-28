package cn.com.crowdsourcedtesting.DAO;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.crowdsourcedtesting.bean.Tester;


/**
 * A data access object (DAO) providing persistence and search support for
 * Tester entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.com.crowdsourcedtesting.bean.Tester
 * @author MyEclipse Persistence Tools
 */

public class TesterDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TesterDAO.class);
	// property constants
	public static final String TESTER_NAME = "testerName";
	public static final String TESTER_EMAIL = "testerEmail";
	public static final String TESTER_PASSWORD = "testerPassword";
	public static final String TESTER_GENDER = "testerGender";
	public static final String TESTER_MOBILE = "testerMobile";
	public static final String TESTER_PHOTO = "testerPhoto";
	public static final String TESTER_CREDIT = "testerCredit";

	public void save(Tester transientInstance) {
		log.debug("saving Tester instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Tester persistentInstance) {
		log.debug("deleting Tester instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tester findById(java.lang.Integer id) {
		log.debug("getting Tester instance with id: " + id);
		try {
			Tester instance = (Tester) getSession().get(
					"cn.com.crowdsourcedtesting.DAO.Tester", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Tester instance) {
		log.debug("finding Tester instance by example");
		try {
			List results = getSession()
					.createCriteria("cn.com.crowdsourcedtesting.DAO.Tester")
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
		log.debug("finding Tester instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Tester as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTesterName(Object testerName) {
		return findByProperty(TESTER_NAME, testerName);
	}

	public List findByTesterEmail(Object testerEmail) {
		return findByProperty(TESTER_EMAIL, testerEmail);
	}

	public List findByTesterPassword(Object testerPassword) {
		return findByProperty(TESTER_PASSWORD, testerPassword);
	}

	public List findByTesterGender(Object testerGender) {
		return findByProperty(TESTER_GENDER, testerGender);
	}

	public List findByTesterMobile(Object testerMobile) {
		return findByProperty(TESTER_MOBILE, testerMobile);
	}

	public List findByTesterPhoto(Object testerPhoto) {
		return findByProperty(TESTER_PHOTO, testerPhoto);
	}

	public List findByTesterCredit(Object testerCredit) {
		return findByProperty(TESTER_CREDIT, testerCredit);
	}

	public List findAll() {
		log.debug("finding all Tester instances");
		try {
			String queryString = "from Tester";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Tester merge(Tester detachedInstance) {
		log.debug("merging Tester instance");
		try {
			Tester result = (Tester) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Tester instance) {
		log.debug("attaching dirty Tester instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tester instance) {
		log.debug("attaching clean Tester instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}