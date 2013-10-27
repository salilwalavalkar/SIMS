package com.tech.sims.dao.base;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Abstract Class provide the Instance of HibernateTemplate to execute the query
 * by it's implementor classes.
 * 
 * @author shailendra
 * @version 1.0
 */
public abstract class AbstractDaoImpl implements IDao {

    /**
     * Instance of HiberanteTemplate.
     */
    protected HibernateTemplate hibernateTemplate;

    /**
     * Create a Instance of HibernateTemplate which is used by it Object at dao
     * layer by extending the AbstractDaoImpl.
     * 
     * @param sessionFactory
     *            - session factory interface provide the session instance.
     */
    public void setSessionFactory(final SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
}
