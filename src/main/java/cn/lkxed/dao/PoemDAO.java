package cn.lkxed.dao;

import java.util.List;

public class PoemDAO extends BaseHibernateDAO implements IPoemDAO {
    @Override
    public List findByHql(String hql) {
        return null;
    }
}
