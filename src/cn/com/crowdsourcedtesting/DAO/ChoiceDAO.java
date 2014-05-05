package cn.com.crowdsourcedtesting.DAO;

import cn.com.crowdsourcedtesting.base.BaseHibernateDAO;
import cn.com.crowdsourcedtesting.bean.Choice;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Choice entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.com.crowdsourcedtesting.bean.Choice
 * @author MyEclipse Persistence Tools
 */

public class ChoiceDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ChoiceDAO.class);
	// property constants
	public static final String CHOICE_CONTENT = "choiceContent";
	public static final String SELECT_COUNT = "selectCount";

	public void save(Choice transientInstance) {
		log.debug("saving Choice instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Choice persistentInstance) {
		log.debug("deleting Choice instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Choice findById(java.lang.Integer id) {
		log.debug("getting Choice instance with id: " + id);
		try {
			Choice instance = (Choice) getSession().get(
					"cn.com.crowdsourcedtesting.bean.Choice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Choice instance) {
		log.debug("finding Choice instance by example");
		try {
			List results = getSession()
					.createCriteria("cn.com.crowdsourcedtesting.bean.Choice")
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
		log.debug("finding Choice instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Choice as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByChoiceContent(Object choiceContent) {
		return findByProperty(CHOICE_CONTENT, choiceContent);
	}

	public List findBySelectCount(Object selectCount) {
		return findByProperty(SELECT_COUNT, selectCount);
	}

	public List findAll() {
		log.debug("finding all Choice instances");
		try {
			String queryString = "from Choice";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Choice merge(Choice detachedInstance) {
		log.debug("merging Choice instance");
		try {
			Choice result = (Choice) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Choice instance) {
		log.debug("attaching dirty Choice instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Choice instance) {
		log.debug("attaching clean Choice instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}