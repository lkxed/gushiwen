package cn.lkxed.action;

import cn.lkxed.po.Poem;
import cn.lkxed.service.PoemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.Parameter;

import java.util.List;

public class chooseAction extends ActionSupport {
    private List poems;

    public Poem getPoem() {
        return poem;
    }

    public void setPoem(Poem poem) {
        this.poem = poem;
    }

    private Poem poem;

    private PoemService poemService;

    public List getPoems() {
        return poems;
    }

    public void setPoems(List poems) {
        this.poems = poems;
    }

    public void setPoemService(PoemService poemService) {
        this.poemService = poemService;
    }

    public String poem() {
        try {
            poemService.findByTitle(poem.getTitle());
            HttpParameters parameters = ActionContext.getContext().getParameters();
            if (parameters.size() == 0) { // 请求不带参数
                this.poems = poemService.findPage(1, 10);
                Poem a = (Poem) poems.get(0);
                System.out.println(a.getAuthor().getName());
            } else if (parameters.size() == 1) { // 请求带一个参数
                Parameter parameter = parameters.entrySet().iterator().next().getValue();
                if (parameter.getName().equalsIgnoreCase("title")) { // 根据标题查找
                    this.poems = poemService.findByTitle(parameter.getValue());
                    Poem a = (Poem) poems.get(0);
                    System.out.println(a.getTitle());
                } else { // 参数无效
                    return ERROR;
                }
            } else { // 参数过多
                return ERROR;
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
}
