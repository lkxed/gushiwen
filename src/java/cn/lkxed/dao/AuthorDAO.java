package cn.lkxed.dao;

import java.util.List;

public class AuthorDAO extends BaseHibernateDAO implements IAuthorDAO {
    @Override
    public List findByHql(String hql) {
        return null;
    }
}
