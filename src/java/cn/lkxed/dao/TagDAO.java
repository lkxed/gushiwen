package cn.lkxed.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class TagDAO extends BaseHibernateDAO implements ITagDAO {
    @Override
    public List findByHql(String hql) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            Query queryObject = session.createQuery(hql);
            transaction.commit();
            return queryObject.list();
        } catch (RuntimeException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
