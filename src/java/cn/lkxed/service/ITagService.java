package cn.lkxed.service;

import java.util.List;

public interface ITagService {
    public List findAllTags();
    public boolean isExisted(String name);
}
