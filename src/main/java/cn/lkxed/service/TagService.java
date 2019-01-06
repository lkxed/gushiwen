package cn.lkxed.service;

import cn.lkxed.dao.TagDAO;

import java.text.MessageFormat;
import java.util.List;

public class TagService implements ITagService {
    private TagDAO tagDAO = null;

    public void setTagDAO(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    @Override
    public List findAllTags() {
        String hql = "from Tag";
        return tagDAO.findByHql(hql);
    }

    @Override
    public boolean isExisted(String name) {
        String hql = "from Tag where name = {0}";
        hql = MessageFormat.format(hql, name);
        return tagDAO.findByHql(hql).size() > 0;
    }
}
