package com.operation.qkwall.controller;
import com.alibaba.fastjson.JSONObject;
import com.operation.qkwall.entity.Admin;
import com.operation.qkwall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value={"/login","/"})
    @ResponseBody
    public ModelAndView login(Model model) {

        try {
            Authentication auth = SecurityContextHolder.getContext()
                    .getAuthentication();
            if (auth instanceof AnonymousAuthenticationToken) {
                return  new ModelAndView("login");
            } else {
                //获取用户登录权限详细
                Object  pinciba=auth.getPrincipal();
                if(pinciba instanceof UserDetails){
                    UserDetails userDetail = ((UserDetails) pinciba);
                    model.addAttribute("username", userDetail.getUsername());
                    Admin u =userService.getUserByname(userDetail.getUsername());
                    model.addAttribute("realName",u.getRealname());
                }

                //登录成功跳到主页
                return  new ModelAndView("index");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  new ModelAndView("login");
        }


    }

    /**
     * 无权限访问页
     * @return
     */
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.setViewName("403");
        return model;
    }

    /**
     * 添加一个用户
     * @param admin
     * @return
     */
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/addAdmin",method=RequestMethod.POST)
    @ResponseBody
    public JSONObject addSingleUser(@ModelAttribute(value="admin")Admin admin){
        JSONObject result=new JSONObject();
        String res;
        String mes;
        try{
            userService.save(admin);
            res="success";
            mes="添加成功！";
            result.put("mes",mes);
            result.put("res",res);
        }catch (Exception e){
            res="failed";
            mes="添加失败";
            result.put("mes",mes);
            result.put("res",res);
        }
        return result;
    }


    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @RequestMapping(value = "/adminList")
    @ResponseBody
    public JSONObject adminList(){
        JSONObject result=new JSONObject();
        String res;
        Object mes;
         List<Admin> adminList=null;
        try{
            adminList = userService.getAdminList();
            res="success";
            mes=adminList;
            result.put("mes",mes);
            result.put("res",res);
        }catch (Exception e){
            res="failed";
            mes=adminList;
            result.put("mes",mes);
            result.put("res",res);
        }
        return result;
    }



}
