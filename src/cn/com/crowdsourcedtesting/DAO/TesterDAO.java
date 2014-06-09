package cn.com.crowdsourcedtesting.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.crowdsourcedtesting.base.BaseHibernateDAO;
import cn.com.crowdsourcedtesting.bean.Tester;
import cn.com.other.page.Page;

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
		log.debug("saving Driver instance");
		Session session = getSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();
			session.save(transientInstance);
			tran.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			tran.rollback();
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
					"cn.com.crowdsourcedtesting.bean.Tester", id);
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
					.createCriteria("cn.com.crowdsourcedtesting.bean.Tester")
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

	// 判断是否为Tester
	public Tester isTester(String email, String password) {
		Tester tester = null;
		List<Tester> testers = this.findByProperty(TESTER_EMAIL,
				email);
		if (testers != null && testers.size() != 0) {
			tester = testers.get(0);
			if (!tester.getTesterPassword().equals(password)) {
				tester = null;
			}
		}
		return tester;
	}
	
//	public void testerRegist(String name, String email, String password) {
//		
//	}
	
	
	//模糊搜索
		public List findSimilarPropertyByPage(Page page, String propertyName, Object value) {
			log.debug("search label by property limit");

			try {
				String queryString = "from Tester as model where model."
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
				String queryString = "from Tester as model where model."
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
		

		// 按页查找个人用户
		public List<Tester> findByPage(Page page) {
			// TODO Auto-generated method stub
			try {
				List<Tester> testers = new ArrayList<Tester>();
				String queryString = "from Tester";
				Query queryObject = getSession().createQuery(queryString);

				testers = queryObject
						.setFirstResult(
								(page.getCurrentPage() - 1) * page.getPerRows())
						.setMaxResults(page.getPerRows()).list();

				return testers;
			} catch (RuntimeException re) {
				log.error("find by page failed", re);
				throw re;
			}
		}

		// 得到总条数
		public int getTotalRows() {

			Number c = (Number) getSession()
					.createQuery(
							"select count(*) from Tester")
					.uniqueResult();

			return c.intValue();

		}

}