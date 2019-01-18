package cn.lkxed.service;

import cn.lkxed.dao.TagDAO;

import java.util.List;

public class TagService {
    private TagDAO tagDAO;

    public void setTagDAO(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    public List findAll() {
        return tagDAO.findAll();
    }

    public boolean isExisted(String name) {
        return tagDAO.findAll().size() > 0;
    }

    public List findPage(int pageNum, int pageSize) {
        return tagDAO.findPage(pageNum, pageSize);
    }
}
