package cn.com.crowdsourcedtesting.DAO;

import cn.com.crowdsourcedtesting.base.BaseHibernateDAO;
import cn.com.crowdsourcedtesting.bean.JoinQuestionnaire;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * JoinQuestionnaire entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.com.crowdsourcedtesting.bean.JoinQuestionnaire
 * @author MyEclipse Persistence Tools
 */

public class JoinQuestionnaireDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(JoinQuestionnaireDAO.class);

	// property constants

	public void save(JoinQuestionnaire transientInstance) {
		log.debug("saving JoinQuestionnaire instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(JoinQuestionnaire persistentInstance) {
		log.debug("deleting JoinQuestionnaire instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JoinQuestionnaire findById(java.lang.Integer id) {
		log.debug("getting JoinQuestionnaire instance with id: " + id);
		try {
			JoinQuestionnaire instance = (JoinQuestionnaire) getSession().get(
					"cn.com.crowdsourcedtesting.DAO.JoinQuestionnaire", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(JoinQuestionnaire instance) {
		log.debug("finding JoinQuestionnaire instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"cn.com.crowdsourcedtesting.DAO.JoinQuestionnaire")
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
		log.debug("finding JoinQuestionnaire instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from JoinQuestionnaire as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all JoinQuestionnaire instances");
		try {
			String queryString = "from JoinQuestionnaire";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public JoinQuestionnaire merge(JoinQuestionnaire detachedInstance) {
		log.debug("merging JoinQuestionnaire instance");
		try {
			JoinQuestionnaire result = (JoinQuestionnaire) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(JoinQuestionnaire instance) {
		log.debug("attaching dirty JoinQuestionnaire instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(JoinQuestionnaire instance) {
		log.debug("attaching clean JoinQuestionnaire instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}