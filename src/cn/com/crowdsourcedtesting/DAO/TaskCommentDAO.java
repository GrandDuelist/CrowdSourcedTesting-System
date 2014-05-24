package cn.com.crowdsourcedtesting.DAO;

import cn.com.crowdsourcedtesting.base.BaseHibernateDAO;
import cn.com.crowdsourcedtesting.bean.Recruitment;
import cn.com.crowdsourcedtesting.bean.TaskComment;
import cn.com.other.page.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TaskComment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.com.crowdsourcedtesting.bean.TaskComment
 * @author MyEclipse Persistence Tools
 */

public class TaskCommentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TaskCommentDAO.class);
	// property constants
	public static final String COMMENT_CONTENT = "commentContent";

	public void save(TaskComment transientInstance) {
		log.debug("saving TaskComment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TaskComment persistentInstance) {
		log.debug("deleting TaskComment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TaskComment findById(java.lang.Integer id) {
		log.debug("getting TaskComment instance with id: " + id);
		try {
			TaskComment instance = (TaskComment) getSession().get(
					"cn.com.crowdsourcedtesting.bean.TaskComment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TaskComment instance) {
		log.debug("finding TaskComment instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"cn.com.crowdsourcedtesting.bean.TaskComment")
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
		log.debug("finding TaskComment instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TaskComment as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCommentContent(Object commentContent) {
		return findByProperty(COMMENT_CONTENT, commentContent);
	}

	public List findAll() {
		log.debug("finding all TaskComment instances");
		try {
			String queryString = "from TaskComment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TaskComment merge(TaskComment detachedInstance) {
		log.debug("merging TaskComment instance");
		try {
			TaskComment result = (TaskComment) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TaskComment instance) {
		log.debug("attaching dirty TaskComment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TaskComment instance) {
		log.debug("attaching clean TaskComment instance");
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
			public List findByPage(Page page, int task_id)
			{
				try {
					List<TaskComment> recruitments = new ArrayList<TaskComment>();
					String queryString = "from TaskComment as model where model.TASK_ID =" + task_id;					
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
				
				
	
	//模糊搜索
		public List findSimilarPropertyByPage(Page page, String propertyName, Object value) {
			log.debug("search label by property limit");

			try {
				String queryString = "from TaskComment as model where model."
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
				String queryString = "from TaskComment as model where model."
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