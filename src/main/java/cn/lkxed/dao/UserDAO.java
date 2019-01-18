package cn.lkxed.dao;

import cn.lkxed.po.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class UserDAO extends HibernateDaoSupport implements IUserDAO {
    @Override
    public List find(User user) {
        return getHibernateTemplate().findByExample(user);
    }

    @Override
    public void save(User user) {
        getHibernateTemplate().save(user);
    }

    @Override
    public void update(User user) {
        getHibernateTemplate().update(user);
    }

    @Override
    public void delete(User user) {
        getHibernateTemplate().delete(user);
    }
}
