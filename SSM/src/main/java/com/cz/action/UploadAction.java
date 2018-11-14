package com.cz.action;

import com.cz.util.IDGeneratorUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class UploadAction {
    @RequestMapping
    public String uploadFilePage(){
        return "fileUpload";
    }
    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestParam MultipartFile multipartFile,HttpServletRequest request){
        //获取的是当前工程部署到tomcat服务器中的绝对磁盘路径
        String rootpath = request.getServletContext().getRealPath("upload");
        if(multipartFile!=null){
            String fileName = multipartFile.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            String tempFileName = IDGeneratorUtil.generateID()+ suffix;
            File fileTemp = new File(rootpath);
            if(!fileTemp.exists()){
                fileTemp.mkdirs();
            }
            File file = new File(rootpath + "\\" + tempFileName);
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            request.setAttribute("uploadFilePath","/upload/" + tempFileName);
            request.setAttribute("tempFileName",fileName);
        }
        return "fileUpload";
    }
    @RequestMapping("/uploadFileBatch")
    public String uploadBatch(@RequestParam MultipartFile[] multipartFiles,HttpServletRequest request){
        String rootpath = request.getServletContext().getRealPath("upload");
        Map<String,Object> map = new HashMap<String,Object>();
        if(multipartFiles!=null&&multipartFiles.length>0){
            for(MultipartFile multipartFile:multipartFiles){
                if(multipartFile !=null){
                    // 获取上传文件的名称
                    String fileName = multipartFile.getOriginalFilename();
                    // 得到文件的扩展名
                    String suffix = fileName.substring(fileName.lastIndexOf("."));
                    // 为了防止上传的是同名的文件，需要为上传文件重新命名
                    String tempFileName = IDGeneratorUtil.generateID() + suffix;
                    File fileTemp = new File(rootpath);
                    if(!fileTemp.exists()){
                        fileTemp.mkdirs();
                    }
                    File file = new File(rootpath + "\\" + tempFileName);
                    // 将文件写入到指时定路径
                    try {
                        multipartFile.transferTo(file);
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    map.put(fileName, tempFileName);
                }
            }
            request.setAttribute("uploadMap", map);
        }
        return "fileUpload";
    }
}
