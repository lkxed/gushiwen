package cn.lkxed.service;

import java.util.List;

public interface ITagService {
    public List findAllTags();
    public boolean isExisted(String name);
    public List findPage(int pageNum, int pageSize);
}
