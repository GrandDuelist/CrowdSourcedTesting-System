package cn.com.crowdsourcedtesting.DAO;

import cn.com.crowdsourcedtesting.base.BaseHibernateDAO;
import cn.com.crowdsourcedtesting.bean.BugReport;
import cn.com.other.page.Page;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * BugReport entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.com.crowdsourcedtesting.bean.BugReport
 * @author MyEclipse Persistence Tools
 */

public class BugReportDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BugReportDAO.class);
	// property constants
	public static final String REPORT_TITLE = "reportTitle";
	public static final String REPORT_TYPE = "reportType";
	public static final String PICTURE = "picture";
	public static final String OPERATION = "operation";
	public static final String BUG_LEVEL = "bugLevel";
	public static final String OPERATION_RESULT = "operationResult";
	public static final String IS_SELECTED = "isSelected";

	public void save(BugReport transientInstance) {
		log.debug("saving BugReport instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BugReport persistentInstance) {
		log.debug("deleting BugReport instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BugReport findById(java.lang.Integer id) {
		log.debug("getting BugReport instance with id: " + id);
		try {
			BugReport instance = (BugReport) getSession().get(
					"cn.com.crowdsourcedtesting.bean.BugReport", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BugReport instance) {
		log.debug("finding BugReport instance by example");
		try {
			List results = getSession()
					.createCriteria("cn.com.crowdsourcedtesting.bean.BugReport")
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
		log.debug("finding BugReport instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BugReport as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByReportTitle(Object reportTitle) {
		return findByProperty(REPORT_TITLE, reportTitle);
	}

	public List findByReportType(Object reportType) {
		return findByProperty(REPORT_TYPE, reportType);
	}

	public List findByPicture(Object picture) {
		return findByProperty(PICTURE, picture);
	}

	public List findByOperation(Object operation) {
		return findByProperty(OPERATION, operation);
	}

	public List findByBugLevel(Object bugLevel) {
		return findByProperty(BUG_LEVEL, bugLevel);
	}

	public List findByOperationResult(Object operationResult) {
		return findByProperty(OPERATION_RESULT, operationResult);
	}

	public List findByIsSelected(Object isSelected) {
		return findByProperty(IS_SELECTED, isSelected);
	}

	public List findAll() {
		log.debug("finding all BugReport instances");
		try {
			String queryString = "from BugReport";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BugReport merge(BugReport detachedInstance) {
		log.debug("merging BugReport instance");
		try {
			BugReport result = (BugReport) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BugReport instance) {
		log.debug("attaching dirty BugReport instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BugReport instance) {
		log.debug("attaching clean BugReport instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	
	//模糊搜索
		public List findSimilarPropertyByPage(Page page, String propertyName, Object value) {
			log.debug("search label by property limit");

			try {
				String queryString = "from BugReport as model where model."
						+ propertyName + " like ?";
				Query query = getSession().createQuery(queryString);
				query.setParameter(0, "%"+value+"%");
				query.setFirstResult((page.getCurrentPage()-1)*page.getPerRows());
				query.setMaxResults(page.getPerRows());
				return query.list();
			} catch (RuntimeException re) {
				log.error("find label by property limit failed", re);
				throw re;
			}

		}
		
		public int getTotalSimilarRows(String propertyName, Object value)
		{

			try {					
				String queryString = "from BugReport as model where model."
						+ propertyName + " like ?";
				Query query = getSession().createQuery(queryString);
				query.setParameter(0, "%"+value+"%");
				return query.list().size();
			}
			catch(RuntimeException re) {
				log.error("find by page failed", re);
				throw re;
			}

		}
	
}