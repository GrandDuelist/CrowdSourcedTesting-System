package cn.com.crowdsourcedtesting.DAO;

import cn.com.crowdsourcedtesting.base.BaseHibernateDAO;
import cn.com.crowdsourcedtesting.bean.Recruitment;
import cn.com.other.page.Page;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Recruitment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.com.crowdsourcedtesting.bean.Recruitment
 * @author MyEclipse Persistence Tools
 */

public class RecruitmentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RecruitmentDAO.class);
	// property constants
	public static final String ACTIVITY_NAME = "activityName";
	public static final String ONLINE = "online";
	public static final String CONTENT = "content";
	public static final String BRIEF = "brief";
	public static final String COMPANY = "company";
	public static final String PLACE = "place";
	public static final String RECRUITMENT_TYPE = "recruitmentType";
	public static final String PUBLISHER_ID = "publisherId";
	public static final String CHECK_ADMINISTRATOR_ID = "checkAdministratorId";

	public void save(Recruitment transientInstance) {
		log.debug("saving Recruitment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Recruitment persistentInstance) {
		log.debug("deleting Recruitment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Recruitment findById(java.lang.Integer id) {
		log.debug("getting Recruitment instance with id: " + id);
		try {
			Recruitment instance = (Recruitment) getSession().get(
					"cn.com.crowdsourcedtesting.bean.Recruitment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Recruitment instance) {
		log.debug("finding Recruitment instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"cn.com.crowdsourcedtesting.bean.Recruitment")
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
		log.debug("finding Recruitment instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Recruitment as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByActivityName(Object activityName) {
		return findByProperty(ACTIVITY_NAME, activityName);
	}

	public List findByOnline(Object online) {
		return findByProperty(ONLINE, online);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByBrief(Object brief) {
		return findByProperty(BRIEF, brief);
	}

	public List findByCompany(Object company) {
		return findByProperty(COMPANY, company);
	}

	public List findByPlace(Object place) {
		return findByProperty(PLACE, place);
	}

	public List findByRecruitmentType(Object recruitmentType) {
		return findByProperty(RECRUITMENT_TYPE, recruitmentType);
	}

	public List findByPublisherId(Object publisherId) {
		return findByProperty(PUBLISHER_ID, publisherId);
	}

	public List findByCheckAdministratorId(Object checkAdministratorId) {
		return findByProperty(CHECK_ADMINISTRATOR_ID, checkAdministratorId);
	}

	public List findAll() {
		log.debug("finding all Recruitment instances");
		try {
			String queryString = "from Recruitment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Recruitment merge(Recruitment detachedInstance) {
		log.debug("merging Recruitment instance");
		try {
			Recruitment result = (Recruitment) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Recruitment instance) {
		log.debug("attaching dirty Recruitment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Recruitment instance) {
		log.debug("attaching clean Recruitment instance");
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
				List<Recruitment> recruitments = new ArrayList<Recruitment>();
				String queryString = "from Recruitment";
				
				Query queryObject = getSession().createQuery(queryString);
				queryObject.setFirstResult((page.getCurrentPage()-1)*page.getPerRows());
				queryObject.setMaxResults(page.getPerRows());
				
				recruitments = queryObject.list();						
				return recruitments;
				}
				catch(RuntimeException re) {
					log.error("find by page failed", re);
					throw re;
				}
			}
			
			
		public int getTotalRows()
		{
		
					 Number c= (Number) getSession().createQuery("select count(*) from Recruitment")
					.uniqueResult();
					 
					
					 return c.intValue();
					
					
			//return this.findAll().size();
		}
	
		
		//模糊搜索
		public List findSimilarPropertyByPage(Page page, String propertyName, Object value) {
			log.debug("search label by property limit");

			try {
				String queryString = "from Recruitment as model where model."
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
				String queryString = "from Recruitment as model where model."
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
		
		
		

		//得到特定发布者的招募条数
		public int getCheckedTotalRowsByPublisher(int publisherId)
		{
		
					 Number c= (Number) getSession().createQuery("select count(*) from Recruitment where PUBLISHER_ID="+publisherId)
					.uniqueResult();
					 
					
					 
					 return c.intValue();
					
					
			//return this.findAll().size();
		}
		//按页查找招募信息
	public List<Recruitment> findCheckedByPublisherPage(Page page,int publisherId) {
			// TODO Auto-generated method stub
			try {
				List<Recruitment> recruitments = new ArrayList<Recruitment>();
				String queryString = "from Recruitment where PUBLISHER_ID="+publisherId;
				Query queryObject = getSession().createQuery(queryString);
				
				 recruitments=queryObject
				.setFirstResult((page.getCurrentPage()-1)*page.getPerRows())
				.setMaxResults(page.getPerRows())
				.list();
				
				return recruitments;
				}
				catch(RuntimeException re) {
					log.error("find by page failed", re);
					throw re;
				}
		}
		
		
}