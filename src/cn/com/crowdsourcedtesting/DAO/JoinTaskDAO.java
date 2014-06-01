package cn.com.crowdsourcedtesting.DAO;

// default package

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.crowdsourcedtesting.base.BaseHibernateDAO;
import cn.com.crowdsourcedtesting.base.HibernateSessionFactory;
import cn.com.crowdsourcedtesting.bean.JoinTask;
import cn.com.crowdsourcedtesting.bean.TestTask;
import cn.com.crowdsourcedtesting.bean.Tester;

/**
 * A data access object (DAO) providing persistence and search support for
 * JoinTask entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .JoinTask
 * @author MyEclipse Persistence Tools
 */

public class JoinTaskDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(JoinTaskDAO.class);

	// property constants

	public void save(JoinTask transientInstance) {
		log.debug("saving JoinTask instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(JoinTask persistentInstance) {
		log.debug("deleting JoinTask instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JoinTask findById(java.lang.Integer id) {
		log.debug("getting JoinTask instance with id: " + id);
		try {
			JoinTask instance = (JoinTask) getSession().get("JoinTask", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(JoinTask instance) {
		log.debug("finding JoinTask instance by example");
		try {
			List results = getSession().createCriteria("JoinTask")
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
		log.debug("finding JoinTask instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from JoinTask as model where model."
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
		log.debug("finding all JoinTask instances");
		try {
			String queryString = "from JoinTask";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public JoinTask merge(JoinTask detachedInstance) {
		log.debug("merging JoinTask instance");
		try {
			JoinTask result = (JoinTask) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(JoinTask instance) {
		log.debug("attaching dirty JoinTask instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(JoinTask instance) {
		log.debug("attaching clean JoinTask instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public boolean isExist(Tester tester, TestTask testTask) {
		String queryStr = "from JoinTask as model where model.testTask.taskId = ? and model.tester.testerId = ?";
		try {
			Query query = getSession().createQuery(queryStr);
			query.setParameter(0, testTask.getTaskId());
			query.setParameter(1, tester.getTesterId());
			List list = query.list();
			return (list != null && list.size() > 0);

		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public JoinTask addJoinTask(Tester tester, TestTask testTask) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();
			JoinTask joinTask = new JoinTask(testTask, tester);
			session.save(joinTask);
			tran.commit();
			return joinTask;

		} catch (RuntimeException re) {
			if (tran != null) {
				tran.rollback();
			}
			re.printStackTrace();
			throw re;
		}
	}
}