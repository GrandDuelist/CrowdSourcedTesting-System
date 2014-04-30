package cn.com.crowdsourcedtesting.DAO;

import cn.com.crowdsourcedtesting.base.BaseHibernateDAO;
import cn.com.crowdsourcedtesting.bean.ChangeGift;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ChangeGift entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.com.crowdsourcedtesting.bean.ChangeGift
 * @author MyEclipse Persistence Tools
 */

public class ChangeGiftDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ChangeGiftDAO.class);
	// property constants
	public static final String CREDIT = "credit";
	public static final String SEND_ADDRESS = "sendAddress";

	public void save(ChangeGift transientInstance) {
		log.debug("saving ChangeGift instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ChangeGift persistentInstance) {
		log.debug("deleting ChangeGift instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ChangeGift findById(java.lang.Integer id) {
		log.debug("getting ChangeGift instance with id: " + id);
		try {
			ChangeGift instance = (ChangeGift) getSession().get(
					"cn.com.crowdsourcedtesting.DAO.ChangeGift", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ChangeGift instance) {
		log.debug("finding ChangeGift instance by example");
		try {
			List results = getSession()
					.createCriteria("cn.com.crowdsourcedtesting.DAO.ChangeGift")
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
		log.debug("finding ChangeGift instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ChangeGift as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCredit(Object credit) {
		return findByProperty(CREDIT, credit);
	}

	public List findBySendAddress(Object sendAddress) {
		return findByProperty(SEND_ADDRESS, sendAddress);
	}

	public List findAll() {
		log.debug("finding all ChangeGift instances");
		try {
			String queryString = "from ChangeGift";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ChangeGift merge(ChangeGift detachedInstance) {
		log.debug("merging ChangeGift instance");
		try {
			ChangeGift result = (ChangeGift) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ChangeGift instance) {
		log.debug("attaching dirty ChangeGift instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ChangeGift instance) {
		log.debug("attaching clean ChangeGift instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}