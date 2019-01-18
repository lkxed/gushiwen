package cn.lkxed.service;

import cn.lkxed.dao.TagDAO;

import java.util.List;

public class TagService implements ITagService {
    private TagDAO tagDAO;

    public void setTagDAO(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    @Override
    public List findAll() {
        return tagDAO.findAll();
    }

    @Override
    public boolean isExisted(String name) {
        return tagDAO.findAll().size() > 0;
    }

    @Override
    public List findPage(int pageNum, int pageSize) {
        return tagDAO.findPage(pageNum, pageSize);
    }
}
