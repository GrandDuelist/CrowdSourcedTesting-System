package cn.com.crowdsourcedtesting.DAO;

import cn.com.crowdsourcedtesting.base.BaseHibernateDAO;
import cn.com.crowdsourcedtesting.bean.Administrator;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Administrator entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.com.crowdsourcedtesting.bean.Administrator
 * @author MyEclipse Persistence Tools
 */

public class AdministratorDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AdministratorDAO.class);
	// property constants
	public static final String ADMINISTRATOR_NAME = "administratorName";
	public static final String ADMINISTRATOR_EMAIL = "administratorEmail";
	public static final String ADMINISTRATOR_PASSWORD = "administratorPassword";
	public static final String ADMINISTRATOR_AUTHORITY = "administratorAuthority";
	public static final String ADMINISTRATOR_OCCUPATION = "administratorOccupation";

	public void save(Administrator transientInstance) {
		log.debug("saving Administrator instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Administrator persistentInstance) {
		log.debug("deleting Administrator instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Administrator findById(java.lang.Integer id) {
		log.debug("getting Administrator instance with id: " + id);
		try {
			Administrator instance = (Administrator) getSession().get(
					"cn.com.crowdsourcedtesting.DAO.Administrator", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Administrator instance) {
		log.debug("finding Administrator instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"cn.com.crowdsourcedtesting.DAO.Administrator")
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
		log.debug("finding Administrator instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Administrator as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAdministratorName(Object administratorName) {
		return findByProperty(ADMINISTRATOR_NAME, administratorName);
	}

	public List findByAdministratorEmail(Object administratorEmail) {
		return findByProperty(ADMINISTRATOR_EMAIL, administratorEmail);
	}

	public List findByAdministratorPassword(Object administratorPassword) {
		return findByProperty(ADMINISTRATOR_PASSWORD, administratorPassword);
	}

	public List findByAdministratorAuthority(Object administratorAuthority) {
		return findByProperty(ADMINISTRATOR_AUTHORITY, administratorAuthority);
	}

	public List findByAdministratorOccupation(Object administratorOccupation) {
		return findByProperty(ADMINISTRATOR_OCCUPATION, administratorOccupation);
	}

	public List findAll() {
		log.debug("finding all Administrator instances");
		try {
			String queryString = "from Administrator";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Administrator merge(Administrator detachedInstance) {
		log.debug("merging Administrator instance");
		try {
			Administrator result = (Administrator) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Administrator instance) {
		log.debug("attaching dirty Administrator instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Administrator instance) {
		log.debug("attaching clean Administrator instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}