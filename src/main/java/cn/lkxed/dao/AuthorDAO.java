package cn.lkxed.dao;

import cn.lkxed.po.Author;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class AuthorDAO extends HibernateDaoSupport implements IAuthorDAO {

    @Override
    public List findAll() {
        return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Author.class));
    }

    @Override
    public List findPage(int pageNum, int pageSize) {
        int begin = (pageNum - 1) * pageSize;
        return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Author.class), begin, pageSize);
    }

    @Override
    public List findByExample(Author example) {
        return getHibernateTemplate().findByExample(example);
    }

    @Override
    public List findDynastyAuthorPage(Author example, int pageNum, int pageSize) {
        int begin = (pageNum - 1) * pageSize;
        return getHibernateTemplate().findByExample(example, begin, pageSize);
    }
}
