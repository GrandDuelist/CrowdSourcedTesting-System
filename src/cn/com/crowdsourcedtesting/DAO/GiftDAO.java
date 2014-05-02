package cn.com.crowdsourcedtesting.DAO;

import cn.com.crowdsourcedtesting.base.BaseHibernateDAO;
import cn.com.crowdsourcedtesting.bean.Gift;
import cn.com.other.page.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A data access object (DAO) providing persistence and search support for Gift
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see cn.com.crowdsourcedtesting.bean.Gift
 * @author MyEclipse Persistence Tools
 */

public class GiftDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(GiftDAO.class);
	// property constants
	public static final String GIFT_AMOUNT = "giftAmount";
	public static final String GIFT_CREDIT = "giftCredit";
	public static final String GIFT_NAME = "giftName";
	public static final String GIFT_PHOTO = "giftPhoto";
/*
	public void save(Gift transientInstance) {
		log.debug("saving Gift instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}*/


	public void save(Gift transientInstance) {
		log.debug("saving Driver instance");
		 Session session=getSession();
		try {
			session.beginTransaction();
			getSession().save(transientInstance);
			session.beginTransaction().commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			session.beginTransaction().rollback();
			throw re;
		}
	}
	public void delete(Gift persistentInstance) {
		log.debug("deleting Gift instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Gift findById(java.lang.Integer id) {
		log.debug("getting Gift instance with id: " + id);
		try {
			Gift instance = (Gift) getSession().get(
					"cn.com.crowdsourcedtesting.DAO.Gift", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Gift instance) {
		log.debug("finding Gift instance by example");
		try {
			List results = getSession()
					.createCriteria("cn.com.crowdsourcedtesting.DAO.Gift")
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
		log.debug("finding Gift instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Gift as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGiftAmount(Object giftAmount) {
		return findByProperty(GIFT_AMOUNT, giftAmount);
	}

	public List findByGiftCredit(Object giftCredit) {
		log.debug("finding Gift instance with property: " + GIFT_CREDIT
				+ ", under value: " + giftCredit);
		try {
			String queryString = "from Gift as model where model."
					+ GIFT_CREDIT + "<= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, giftCredit);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGiftName(Object giftName) {
		return findByProperty(GIFT_NAME, giftName);
	}

	public List findByGiftPhoto(Object giftPhoto) {
		return findByProperty(GIFT_PHOTO, giftPhoto);
	}

	public List findAll() {
		log.debug("finding all Gift instances");
		try {
			String queryString = "from Gift";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Gift merge(Gift detachedInstance) {
		log.debug("merging Gift instance");
		try {
			Gift result = (Gift) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Gift instance) {
		log.debug("attaching dirty Gift instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Gift instance) {
		log.debug("attaching clean Gift instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	
	//按页查找
		
			@SuppressWarnings("unchecked")
			public List findByPage(Page page)
			{
				try {
				List<Gift> gifts = new ArrayList<Gift>();
				String queryString = "from Gift";
				Query queryObject = getSession().createQuery(queryString);
				
				 gifts=queryObject
				.setFirstResult((page.getCurrentPage()-1)*page.getPerRows())
				.setMaxResults(page.getPerRows())
				.list();
				
				return gifts;
				}
				catch(RuntimeException re) {
					log.error("find by page failed", re);
					throw re;
				}
					
					
				}
				
				
			
			//得到总的礼品数
			public int getTotalRows()
			{
			
						 Number c= (Number) getSession().createQuery("select count(*) from Gift")
						.uniqueResult();
						 
						
						 return c.intValue();
						
						
				//return this.findAll().size();
			}
			
			
			//
			@SuppressWarnings("unchecked")
			public List findAvailableByPage(Object giftCredit, Page page)
			{
				try {
				List<Gift> gifts = new ArrayList<Gift>();
				
				String queryString = "from Gift as model where model."
						+ GIFT_CREDIT + "<= ?";
				Query queryObject = getSession().createQuery(queryString);
				queryObject.setParameter(0, giftCredit);
				
				 gifts=queryObject
				.setFirstResult((page.getCurrentPage()-1)*page.getPerRows())
				.setMaxResults(page.getPerRows())
				.list();
				
				return gifts;
				}
				catch(RuntimeException re) {
					log.error("find by page failed", re);
					throw re;
				}
					
					
				}
				
				
			
			//得到总的礼品数
			public int getTotalAvailableRows(Double giftCredit)
			{
			
				try {					
					String queryString = "from Gift as model where model."
							+ GIFT_CREDIT + "<= ?";
					Query queryObject = getSession().createQuery(queryString);
					queryObject.setParameter(0, giftCredit);
					return queryObject.list().size();
				}
				catch(RuntimeException re) {
						log.error("find by page failed", re);
						throw re;
					}
				
			}
			
}