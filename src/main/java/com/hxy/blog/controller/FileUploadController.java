package com.hxy.blog.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;


@Controller
@RequestMapping("/upFile")
public class FileUploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

    private static final String SUCCESS = "success";
//    @Value("${imageUpload.url}")
//    private String path;
    @ResponseBody
    @RequestMapping("/uploadImg")
    public JSONObject uploadImg(HttpServletRequest request , HttpServletResponse response , @RequestParam(value = "file", required=false) MultipartFile file){
        JSONObject res = upload(request , response , file);
        return res;
    }
    @ResponseBody
    @RequestMapping("/editorImg")
    public JSONObject editorImg(HttpServletRequest request , HttpServletResponse response , @RequestParam(value = "editormd-image-file", required = false) MultipartFile file){
        JSONObject res = upload(request , response , file);
        return res;
    }

//    @ResponseBody
//    @RequestMapping("/uploadImg")
    public JSONObject upload(HttpServletRequest request , HttpServletResponse response,  MultipartFile file){
        JSONObject res  =new JSONObject();
        try{
            //构建文件输入流InputStream  如果要引入的是本地的文件要在实例化输入流的时候将本地路径当做入参传入
            //构建文件输入流后构建文件缓冲区：byte[] bytes = new byte[1024];
            //将输入流读入文件缓冲区中 in.read(bytes)   这里读入是将缓冲区给输入流 让输入流知道读哪
            //读成功后 文件流这时被读入dytes 构建输出流 OutputStream 实例化入参是读出路径 该路径的文件必须是创建好的  所以要先判断是否有该文件
            //所以要文件.exists()如果返回值是真表示没有该文件就要创建该文件 file.mkdir() 文件创建的时候要将路径作为实例化参数
            //然后将out.write(bytes);将bytes作为参数放入输出写入就将该文件保存到该路径了
            request.setCharacterEncoding( "utf-8" );
            response.setHeader( "Content-Type" , "application/json" );
            //获取上传文件名
            String fileName = file.getOriginalFilename();
            //如果文件名为空则返回失败信息

            if(file.isEmpty()){
                res.put("success",0);
                res.put("message","上传文件为空");
                return res;
            }
            if(StringUtils.isEmpty(fileName)){
                res.put("success",0);
                res.put("message","文件名为空");
                return res;
            }
            //如果type有值表示该文件不是从editor传来的
            if(request.getParameter("type") != null){
                //file =  upfile;
            }
            //获得扩展名
            String fileExtName = (fileName.substring(fileName.lastIndexOf(".")+1)).toLowerCase();
            //判断后缀名是否是图片格式 忽略后缀大小的判定
           if(!fileExtName.equals("jpeg")&&!fileExtName.equals("jpg")&&!fileExtName.equals("png")&&!fileExtName.equals("gif")&&!fileExtName.equals("ico")
                   &&!fileExtName.equals("bmp")&&!fileExtName.equals("img")&&!fileExtName.equals("webp")){
               res.put("success",0);
               res.put("message","文件格式不正确");
               return res;
            }
            //创建获取时间方法
            Calendar now = Calendar.getInstance();
//            File ffff = new File("c:"+File.separator+"workspace"+File.separator+"file"+File.separator+now.get(Calendar.YEAR)+File.separator+(now.get(Calendar.MONTH)+1)+File.separator+now.get(Calendar.DAY_OF_MONTH)+File.separator+file.getOriginalFilename());
////            if(!ffff.getParentFile().exists()){
////                ffff.getParentFile().mkdirs();
////            }
            //file.transferTo(ffff);
            //获取根路径
            String url = System.getProperty("user.dir");
            //String rootPath = "c:"+File.separator+"workspace"+File.separator+"blog"+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"img"+File.separator+now.get(Calendar.YEAR);
            String rootPath = url+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"img"+File.separator+now.get(Calendar.YEAR);
            //定义输出文件
            File filePath = new File(rootPath);
            if(!filePath.exists()){
                filePath.mkdir();
            }
            String nextPath = rootPath+File.separator+(now.get(Calendar.MONTH)+1);
            File nextFile = new File(nextPath);
            if(!nextFile.exists()){
                nextFile.mkdir();
            }
            String endPath = nextPath+File.separator+now.get(Calendar.DAY_OF_MONTH);
            File endFile = new File(endPath);
            if(!endFile.exists()){
                endFile.mkdir();
            }
            //最终文件名路径
            Random random = new Random();
            String newFileName = random.nextInt(100)+fileName;
            File lastFile = new File(endPath+File.separator+newFileName);
            //定义文件输出流 将输出路径作为参数
           // FileOutputStream outfile = new FileOutputStream(lastFile);
            //构建文件缓冲区
           // byte[] bytes = new byte[1024];
            //将文件流读入缓冲区中，
//            outfile.write(file.getInputStream().read(bytes));
//            outfile.flush();
//            outfile.close();
            String newPath = endPath.split("resources")[1];
            file.transferTo(lastFile);
            res.put("success",1);
            res.put("message","上传成功");
            res.put("url",newPath+File.separator+newFileName);
        }catch (IOException e){
            LOGGER.error("上传图片异常", e);
            res.put("success", 0);
            res.put("message", "上传异常");
        }

        return res;
    }

}
