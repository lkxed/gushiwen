package cn.lkxed.dao;

import cn.lkxed.po.Admin;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class AdminDAO extends HibernateDaoSupport implements IAdminDAO {
    @Override
    public List find(Admin admin) {
        return getHibernateTemplate().findByExample(admin);
    }
}
