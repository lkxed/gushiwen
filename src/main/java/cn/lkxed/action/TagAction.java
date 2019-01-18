package cn.lkxed.action;

import cn.lkxed.service.TagService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class TagAction extends ActionSupport {
    private List tags;

    TagService tagService;


    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }

    public List getTags() {
        return tags;
    }

    public void setTags(List tags) {
        this.tags = tags;
    }

    public String execute() {
        List tags = tagService.findPage(1, 10);
        if (tags != null && tags.size() > 0) {
            this.tags = tags;
            return SUCCESS;
        }
        return SUCCESS;
    }
}
