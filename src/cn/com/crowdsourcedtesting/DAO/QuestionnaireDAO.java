package cn.com.crowdsourcedtesting.DAO;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.crowdsourcedtesting.bean.Questionnaire;

/**
 * A data access object (DAO) providing persistence and search support for
 * Questionnaire entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.com.crowdsourcedtesting.bean.Questionnaire
 * @author MyEclipse Persistence Tools
 */

public class QuestionnaireDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(QuestionnaireDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String CREDIT = "credit";
	public static final String QUESTIONNAIRE_COUNT = "questionnaireCount";

	public void save(Questionnaire transientInstance) {
		log.debug("saving Questionnaire instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Questionnaire persistentInstance) {
		log.debug("deleting Questionnaire instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Questionnaire findById(java.lang.Integer id) {
		log.debug("getting Questionnaire instance with id: " + id);
		try {
			Questionnaire instance = (Questionnaire) getSession().get(
					"cn.com.crowdsourcedtesting.DAO.Questionnaire", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Questionnaire instance) {
		log.debug("finding Questionnaire instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"cn.com.crowdsourcedtesting.DAO.Questionnaire")
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
		log.debug("finding Questionnaire instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Questionnaire as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByCredit(Object credit) {
		return findByProperty(CREDIT, credit);
	}

	public List findByQuestionnaireCount(Object questionnaireCount) {
		return findByProperty(QUESTIONNAIRE_COUNT, questionnaireCount);
	}

	public List findAll() {
		log.debug("finding all Questionnaire instances");
		try {
			String queryString = "from Questionnaire";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Questionnaire merge(Questionnaire detachedInstance) {
		log.debug("merging Questionnaire instance");
		try {
			Questionnaire result = (Questionnaire) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Questionnaire instance) {
		log.debug("attaching dirty Questionnaire instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Questionnaire instance) {
		log.debug("attaching clean Questionnaire instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}