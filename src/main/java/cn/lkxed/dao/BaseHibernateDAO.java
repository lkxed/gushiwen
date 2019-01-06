package cn.lkxed.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BaseHibernateDAO {
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.openSession();
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
