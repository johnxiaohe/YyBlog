package com.hxy.blog.controller;


import com.hxy.blog.entity.DicLink;
import com.hxy.blog.service.DicLinkService;
import com.hxy.blog.util.PageBean;
import com.hxy.blog.util.ReturnDatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RequestMapping("/diclink")
@Controller
public class DicLinkController {

    @Autowired
    private DicLinkService dicLinkServiceImpl;

    @RequestMapping("/saveLink/json")
    @ResponseBody
    public ReturnDatas saveLink(HttpServletResponse response , HttpServletRequest request , Model model , DicLink dicLink)throws Exception{
        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();

        if(dicLink.getLogo()==null||dicLink.getFriendLink()==null||dicLink.getFriendName()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"必传logo、链接、名称");
        }

        dicLink.setCreateTime(new Date());
        dicLinkServiceImpl.saveLink(dicLink);

        returnObject.setMessage("添加成功");
        return returnObject;

    }

    @RequestMapping("/modifyLink")
    public String modifyLink(HttpServletRequest request , HttpServletResponse response , Model model , DicLink dicLink){
        try {
            ReturnDatas returnObject = new ReturnDatas();
            if(dicLink.getId()!=null){
                returnObject = findLinkJson(response , request ,  model , dicLink);
            }
            model.addAttribute("returnObject",returnObject);
            return "admin/modifyLink";
        }catch (Exception e){
            return "admin/friendlinks";
        }
    }

    /**
     * 删除该连接
     * @param response
     * @param request
     * @param model
     * @param dicLink
     * @return
     * @throws Exception
     */
    @RequestMapping("/delLink/json")
    @ResponseBody
    public ReturnDatas delLink(HttpServletResponse response , HttpServletRequest request , Model model , DicLink dicLink)throws Exception{
        if(dicLink.getId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"请传入Id");
        }

        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        returnObject.setCode("0");
        dicLinkServiceImpl.delLink(dicLink.getId());
        returnObject.setMessage("删除成功");
        return returnObject;

    }

    /**
     * 修改连接
     * @param response
     * @param request
     * @param model
     * @param dicLink
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateLink/json")
    @ResponseBody
    public ReturnDatas updateLinkJson(HttpServletResponse response , HttpServletRequest request , Model model , DicLink dicLink)throws Exception{
        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        if(dicLink.getLogo()==null||dicLink.getFriendLink()==null||dicLink.getFriendName()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"必传logo、链接、名称");
        }
        if(dicLink.getId()==null){
            dicLink.setCreateTime(new Date());
            dicLinkServiceImpl.saveLink(dicLink);
            returnObject.setMessage("添加成功");
        }else{
            dicLinkServiceImpl.updateLink(dicLink);
            returnObject.setMessage("修改成功");
        }
        return  returnObject;
    }
    @RequestMapping("/findLink/json")
    @ResponseBody
    public ReturnDatas findLinkJson(HttpServletResponse response , HttpServletRequest request , Model model , DicLink dicLink)throws Exception{
        if(dicLink.getId()==null){
            return new ReturnDatas(ReturnDatas.ERROR,"Id不存在");
        }
        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        returnObject.setMessage("请求成功");
        DicLink dicLinkData = dicLinkServiceImpl.findLink(dicLink.getId());
        returnObject.setData(dicLinkData);
        return returnObject;
    }

    /**
     * 查找所有连接
     * @param response
     * @param request
     * @param model
     * @param dicLink
     * @return
     * @throws Exception
     */
    @RequestMapping("/findLinkAll")
    public String findLinkAll(HttpServletResponse response , HttpServletRequest request , Model model , DicLink dicLink)throws Exception{
        ReturnDatas returnObject = linkAll(response,request,model,dicLink);
        model.addAttribute("returnObject",returnObject);
        return "link";
    }
    @RequestMapping("/findLinkAll/json")
    @ResponseBody
    public ReturnDatas linkAll(HttpServletResponse response , HttpServletRequest request , Model model , DicLink dicLink)throws Exception{
        ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
        returnObject.setMessage("成功获取");
        List<DicLink> data = dicLinkServiceImpl.findLinkAll();
        returnObject.setData(data);
        return returnObject;
    }

}
