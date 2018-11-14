package com.cz.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class JsonResult {
    private int code;//代码，表示这个结果集是成功，还是失败，还是其他？相当于http请求返回代码如200代表成功

    private String msg;//返回信息，可以弹出窗体信息

    private Object obj;

    public static JsonResult getJsonResult(int code,String msg,Object obj){
        return new JsonResult(code,msg,obj);
    }
}
