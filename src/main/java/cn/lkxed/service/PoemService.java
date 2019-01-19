package cn.lkxed.service;

import cn.lkxed.dao.PoemDAO;
import cn.lkxed.po.Author;
import cn.lkxed.po.Poem;
import cn.lkxed.po.User;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
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

    public List findByTitle2(Poem poem) {
        return poemDAO.findBean(poem);
    }

    public void delete(Poem poem) {
       poemDAO.delete(poem);
    }

    public void update(Poem poem) {
        poemDAO.update(poem);
    }

    public void save(Poem poem) {
        poemDAO.save(poem);
    }

    public List findById(String id) {
        return poemDAO.findById(id);
    }

    public List findByAuthor(Author author) {
        return poemDAO.findByAuthor(author);
    }
}
