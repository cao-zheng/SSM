package com.cz.tld;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Page extends TagSupport {
    @Getter@Setter
    private String url;
    @Getter@Setter
    private int pageSize = 10;
    @Getter@Setter
    private int pageNo = 1;
    @Getter@Setter
    private int totalCount;
    public int doStartTag(){
        int pageCount = (totalCount + pageSize - 1)/pageSize;
        StringBuilder sb = new StringBuilder();
        sb.append("总共"+pageCount+"页,当前第"+pageNo+"页，总共"+totalCount+"条");
        sb.append("<a href=\"javascript:void(0)\" onclick=\"dopage(1)\">首页</a>");
        if(pageNo != 1){
            sb.append("<a href=\"javascript:void(0)\" onclick=dopage("+(pageNo - 1)+")>上一页</a>");
        }
        if(pageNo != pageCount){
            sb.append("<a href=\"javascript:void(0)\" onclick=dopage("+(pageNo + 1)+")>下一页</a>");
        }
        sb.append("<a href=\"javascript:void(0)\" onclick=dopage("+pageCount+")>尾页</a>");
        sb.append("<script type=\"text/javascript\">"+
                "function dopage(pageNo){"+
                "window.location.href=\""+url+"/"+"\"+pageNo}"+
                "</script>");
        try {
            pageContext.getOut().println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
