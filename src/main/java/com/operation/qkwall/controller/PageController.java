package com.operation.qkwall.controller;
import com.operation.qkwall.entity.Task;
import com.operation.qkwall.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @Autowired
    TaskService taskService;

    @RequestMapping("/toList")
    public String taskList()
    {
        return "/task_list.html";
    }


    @RequestMapping("/toAdd")
    public String taskConfig()
    {
        return "/add_task.html";
    }

    @RequestMapping("/addUser")
    public String addUser()
    {
        return "/add_user.html";
    }

    @RequestMapping("/adminList")
    public String adminList()
    {
        return "/admin_list.html";
    }


    @RequestMapping("/changeTask")
    public String  changeTask(final int id, ModelMap modelMap)
    {
        final Task task = taskService.selectById(id);
        modelMap.put("task",task);
        return "update_task.html";
    }

}
