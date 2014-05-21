package cn.com.crowdsourcedtesting.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.crowdsourcedtesting.base.BaseHibernateDAO;
import cn.com.crowdsourcedtesting.bean.Product;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.bean.TestTask;

/**
 * A data access object (DAO) providing persistence and search support for
 * TestTask entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.com.crowdsourcedtesting.bean.TestTask
 * @author MyEclipse Persistence Tools
 */

public class TestTaskDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TestTaskDAO.class);
	// property constants
	public static final String TASK_TYPE = "taskType";
	public static final String CHECKED_ADMINISTRATOR_ID = "checkedAdministratorId";
	public static final String TASK_ENVIRONMENT = "taskEnvironment";
	public static final String PER_REWARD = "perReward";
	public static final String WHOLE_CREDIT = "wholeCredit";

	public void save(TestTask transientInstance) {
		log.debug("saving TestTask instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TestTask persistentInstance) {
		log.debug("deleting TestTask instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TestTask findById(java.lang.Integer id) {
		log.debug("getting TestTask instance with id: " + id);
		try {
			TestTask instance = (TestTask) getSession().get(
					"cn.com.crowdsourcedtesting.bean.TestTask", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TestTask instance) {
		log.debug("finding TestTask instance by example");
		try {
			List results = getSession()
					.createCriteria("cn.com.crowdsourcedtesting.bean.TestTask")
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
		log.debug("finding TestTask instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TestTask as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTaskType(Object taskType) {
		return findByProperty(TASK_TYPE, taskType);
	}

	public List findByCheckedAdministratorId(Object checkedAdministratorId) {
		return findByProperty(CHECKED_ADMINISTRATOR_ID, checkedAdministratorId);
	}

	public List findByTaskEnvironment(Object taskEnvironment) {
		return findByProperty(TASK_ENVIRONMENT, taskEnvironment);
	}

	public List findByPerReward(Object perReward) {
		return findByProperty(PER_REWARD, perReward);
	}

	public List findByWholeCredit(Object wholeCredit) {
		return findByProperty(WHOLE_CREDIT, wholeCredit);
	}

	public List findAll() {
		log.debug("finding all TestTask instances");
		try {
			String queryString = "from TestTask";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TestTask merge(TestTask detachedInstance) {
		log.debug("merging TestTask instance");
		try {
			TestTask result = (TestTask) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TestTask instance) {
		log.debug("attaching dirty TestTask instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TestTask instance) {
		log.debug("attaching clean TestTask instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public TestTask addTestTask(Product product, Publisher publisher,
			Date beginTime, Date endTime, double perReward, double wholeCredit) {
		Session session = getSession();
		Transaction trans = null;
		TestTask testTask = null;
		try {
			trans = session.beginTransaction();

			testTask = new TestTask(product, publisher, true, perReward,
					wholeCredit);
			testTask.setTaskStartTime(beginTime);
			testTask.setTaskEndTime(endTime);
			session.save(testTask);

			trans.commit();
			log.debug("add testtask successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			if (trans != null) {
				trans.rollback();
			}
			testTask = null;
			throw re;
		}
		return testTask;
	}

}