package cn.lkxed.service;

import cn.lkxed.dao.AuthorDAO;
import cn.lkxed.po.Author;

import java.util.List;

public class AuthorService implements IAuthorService {
    private AuthorDAO authorDAO;

    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }

    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    public List findAll() {
        return authorDAO.findAll();
    }

    @Override
    public boolean isExisted(String name) {
        return this.findByName(name).size() > 0;
    }

    @Override
    public List findPage(int pageNum, int pageSize) {
        return authorDAO.findPage(pageNum, pageSize);
    }

    @Override
    public List findByName(String name) {
        Author example = new Author();
        example.setName(name);
        return authorDAO.findByExample(example);
    }
}
