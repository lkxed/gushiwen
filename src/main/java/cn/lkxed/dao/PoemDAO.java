package cn.lkxed.dao;

import cn.lkxed.po.Author;
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

    @SuppressWarnings("unchecked")
    public List findBean(Poem poem) {
        int flag=0;
        String hql="from Poem where ";
        if(poem.getTitle()!="")
        {
            hql=hql+"title like '%"+poem.getTitle()+"%' ";
            flag=1;
        }
        if(poem.getAuthor().getName()!="")
        {
            if(flag==1)
                hql=hql+"and ";
            hql=hql+"author.id=author_id and author.name='"+poem.getAuthor().getName()+"'";
            flag=1;
        }
        if(poem.getAuthor().getDynasty()!="")
        {
            if(flag==1)
                hql=hql+"and ";
            hql=hql+"author.id=author_id and author.dynasty  like '%"+poem.getAuthor().getDynasty()+"%'";
            flag=1;
        }
        if(poem.getTags()!="")
        {
            if(flag==1)
                hql=hql+"and ";
            hql=hql+"tags  like '%"+poem.getTags()+"%'";
        }

        System.out.println(hql);
        return super.getHibernateTemplate().find(hql);
    }

    public List findById(String id) {
        String hql = "from Poem where id = '"+id+"'";
        return getHibernateTemplate().find(hql);
    }
    @Override
    public void delete(Poem poem) {
        getHibernateTemplate().delete(poem);
    }
    @Override
    public void update(Poem poem) {
        getHibernateTemplate().update(poem);
    }
    @Override
    public void save(Poem poem) {
        getHibernateTemplate().save(poem);
    }

    @Override
    public List findByAuthor(Author author) {
        String hql = "from Poem where author.id = '" + author.getId() + "'";
        return getHibernateTemplate().find(hql);
    }
}
