package cn.lkxed.dao;

import cn.lkxed.po.Poem;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class PoemDAO extends HibernateDaoSupport implements IPoemDAO {
    @Override
    public List findAll() {
        return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Poem.class));
    }

    @Override
    public List findPage(int pageNum, int pageSize) {
        int begin = (pageNum - 1) * pageSize;
        return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Poem.class), begin, pageSize);
    }

    @Override
    public List findByTitle(String title) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Poem.class)
                .add(Restrictions.eq("title", title));
        return getHibernateTemplate().findByCriteria(criteria);
    }
}
