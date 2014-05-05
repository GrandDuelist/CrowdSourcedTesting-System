package cn.com.crowdsourcedtesting.DAO;

import cn.com.crowdsourcedtesting.base.BaseHibernateDAO;
import cn.com.crowdsourcedtesting.bean.Subcategory;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Subcategory entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.com.crowdsourcedtesting.bean.Subcategory
 * @author MyEclipse Persistence Tools
 */

public class SubcategoryDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SubcategoryDAO.class);
	// property constants
	public static final String SUBCATEGORY_NAME = "subcategoryName";

	public void save(Subcategory transientInstance) {
		log.debug("saving Subcategory instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Subcategory persistentInstance) {
		log.debug("deleting Subcategory instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Subcategory findById(java.lang.Integer id) {
		log.debug("getting Subcategory instance with id: " + id);
		try {
			Subcategory instance = (Subcategory) getSession().get(
					"cn.com.crowdsourcedtesting.bean.Subcategory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Subcategory instance) {
		log.debug("finding Subcategory instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"cn.com.crowdsourcedtesting.bean.Subcategory")
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
		log.debug("finding Subcategory instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Subcategory as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySubcategoryName(Object subcategoryName) {
		return findByProperty(SUBCATEGORY_NAME, subcategoryName);
	}

	public List findAll() {
		log.debug("finding all Subcategory instances");
		try {
			String queryString = "from Subcategory";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Subcategory merge(Subcategory detachedInstance) {
		log.debug("merging Subcategory instance");
		try {
			Subcategory result = (Subcategory) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Subcategory instance) {
		log.debug("attaching dirty Subcategory instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Subcategory instance) {
		log.debug("attaching clean Subcategory instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}