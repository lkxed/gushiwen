package cn.lkxed.action;

import cn.lkxed.service.TagService;

import java.util.List;

public class TagAction {
    private List tags;

    TagService tagService = null;

    public TagService getTagService() {
        return tagService;
    }

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
        List tags = tagService.findAllTags();
        if (tags != null && tags.size() > 0) {
            this.tags = tags;
            return "success";
        }
        return "fail";
    }
}
