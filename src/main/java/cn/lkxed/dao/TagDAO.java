package cn.lkxed.dao;

import cn.lkxed.po.Tag;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class TagDAO extends HibernateDaoSupport implements ITagDAO {
    private DetachedCriteria criteria = DetachedCriteria.forClass(Tag.class);
    @Override
    public List findAll() {
        return getHibernateTemplate().findByCriteria(criteria);
    }

    @Override
    public List findPage(int pageNum, int pageSize) {
        int begin = (pageNum - 1) * pageSize;
        return getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
    }
}
