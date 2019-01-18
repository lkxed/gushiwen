package cn.lkxed.service;

import cn.lkxed.dao.PoemDAO;

import java.util.List;

public class PoemService {
    private PoemDAO poemDAO;

    public void setPoemDAO(PoemDAO poemDAO) {
        this.poemDAO = poemDAO;
    }

    public List findAll() {
        return poemDAO.findAll();
    }

    public boolean isExisted(String title) {
        return poemDAO.findByTitle(title).size() > 0;
    }

    public List findPage(int pageNum, int pageSize) {
        return poemDAO.findPage(pageNum, pageSize);
    }

    public List findByTitle(String title) {
        return poemDAO.findByTitle(title);
    }
}
