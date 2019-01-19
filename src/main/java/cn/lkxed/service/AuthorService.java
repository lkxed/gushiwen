package cn.lkxed.service;

import cn.lkxed.dao.AuthorDAO;
import cn.lkxed.po.Author;

import java.util.List;

public class AuthorService {
    private AuthorDAO authorDAO;

    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }

    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public List findAll() {
        return authorDAO.findAll();
    }

    public boolean isExisted(String name) {
        return this.findByName(name).size() > 0;
    }

    public List findPage(int pageNum, int pageSize) {
        return authorDAO.findPage(pageNum, pageSize);
    }

    public List findByName(String name) {
        Author example = new Author();
        example.setName(name);
        return authorDAO.findByExample(example);
    }

    public List findDynastyAuthorPage(Author author, int pageNum, int pageSize) {
        return authorDAO.findDynastyAuthorPage(author, pageNum, pageSize);
    }
}
