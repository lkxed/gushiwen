package cn.lkxed.service;

import cn.lkxed.dao.PoemDAO;

import java.util.List;

public class PoemService implements IPoemService {
    private PoemDAO poemDAO;

    public void setPoemDAO(PoemDAO poemDAO) {
        this.poemDAO = poemDAO;
    }

    @Override
    public List findAll() {
        return poemDAO.findAll();
    }

    @Override
    public boolean isExisted(String title) {
        return poemDAO.findByTitle(title).size() > 0;
    }

    @Override
    public List findPage(int pageNum, int pageSize) {
        return poemDAO.findPage(pageNum, pageSize);
    }

    @Override
    public List findByTitle(String title) {
        return poemDAO.findByTitle(title);
    }
}
