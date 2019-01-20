package cn.lkxed.action;

import cn.lkxed.po.Author;
import cn.lkxed.po.User;
import cn.lkxed.service.PoemService;
import cn.lkxed.po.Poem;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.Parameter;

import java.util.ArrayList;
import java.util.List;

public class PoemAction extends ActionSupport {
    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PoemService getPoemService() {
        return poemService;
    }

    private int pageNum = 1;
    private int pageSize = 5;
    private List poems;
    private Poem poem;

    private PoemService poemService;

    public Poem getPoem() {return poem;}
    public void setPoem(Poem poem){this.poem=poem;}

    public List getPoems() {
        return poems;
    }

    public void setPoems(List poems) {
        this.poems = poems;
    }

    public void setPoemService(PoemService poemService) {
        this.poemService = poemService;
    }

    public String execute() {
        try {
            HttpParameters parameters = ActionContext.getContext().getParameters();
            if (parameters.size() == 0) { // 请求不带参数
                this.poems = poemService.findPage(1, 10);
            } else if (parameters.size() == 1) { // 请求带一个参数
                Parameter parameter = parameters.entrySet().iterator().next().getValue();
                if (parameter.getName().equalsIgnoreCase("title")) { // 根据标题查找
                    this.poems = poemService.findByTitle(parameter.getValue());
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

    public String goToPage() {
        HttpParameters parameters = ActionContext.getContext().getParameters();
        if (parameters.isEmpty()) {
            this.pageNum = 1;
        } else if(parameters.get("pageNum") !=  null){
            this.pageNum = Integer.parseInt(parameters.get("pageNum").getValue());
        } else {
            return ERROR;
        }
        this.poems = poemService.findPage(pageNum, pageSize);
        ActionContext.getContext().getSession().put("poems", this.poems);
        return SUCCESS;
    }

    public String jump() {
        try {
            HttpParameters parameters = ActionContext.getContext().getParameters();
            this.poems = poemService.findPage(1, 10);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }


    public String searchpoem(){
        poems=poemService.findByTitle2(poem);
        return SUCCESS;
    }

    public String getAuthorPoem() {
        Author author = poem.getAuthor();
        poems = poemService.findByAuthor(author);
        return SUCCESS;
    }


    public String adminpoem()
    {
        try {
            HttpParameters parameters = ActionContext.getContext().getParameters();
            this.poems = poemService.findPage(1, 10);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String searchpoem_admin(){
        poems=poemService.findByTitle2(poem);
        return SUCCESS;
    }

    public String deletepoem(){
        System.out.println(poem.getId());
        poemService.delete(poem);
        this.poems = poemService.findPage(1, 10);
        return SUCCESS;
    }
    public String changepoem(){
        poem=(Poem)poemService.findByTitle(poem.getTitle()).get(0);
        return SUCCESS;
    }

    public String poemupdate(){
        System.out.println(poem.getId());
        poemService.update(poem);
        this.poems = poemService.findPage(1, 10);
        return SUCCESS;
    }

    public String poemup(){
        poem.setId(poem.getTitle());
        poemService.save(poem);
        this.poems = poemService.findPage(1, 10);
        return SUCCESS;
    }

    public String jumpuser(){
        return SUCCESS;
    }

    public String bookmark() {
        User user = (User)ActionContext.getContext().getSession().get("nowuser");
        if (user != null) {
            String bookMark = user.getBookmark();
            List markPoems = new ArrayList<Poem>();
            if (markPoems.size() == 0) {
                return SUCCESS;
            }
            for (String poemId : bookMark.split(",")) {
                if (poemId != "" && poemService.findById(poemId).size() == 1)
                    markPoems.add((Poem) poemService.findById(poemId).get(0));
                System.out.println("size: " + markPoems.size());
            }
            ActionContext.getContext().getSession().put("markPoems", markPoems);
        }
        return SUCCESS;
    }
}
