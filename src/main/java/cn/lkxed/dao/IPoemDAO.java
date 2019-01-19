package cn.lkxed.dao;

import cn.lkxed.po.Poem;
import cn.lkxed.po.User;

import java.util.List;

public interface IPoemDAO {
    public List findAll();
    public List findPage(int pageNum, int pageSize);
    public List findByTitle(String title);
    public void delete(Poem poem);
    public void update(Poem poem);
    public void save(Poem poem);
}
