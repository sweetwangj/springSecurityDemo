package com.operation.qkwall.controller;
import com.alibaba.fastjson.JSONObject;
import com.operation.qkwall.entity.Task;
import com.operation.qkwall.http.HttpAPIService;
import com.operation.qkwall.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("config")
public class ConfigController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    TaskService taskService;
    @Autowired
    HttpAPIService httpAPIService;

    @Value("${pvpgame.serverUrl}")
    private String SERVERURL;

    @Value("${pvpgame.iconPath}")
    private String ICONPATH;

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @RequestMapping("/addTask")
    public String  configTask(Task task)
    {
        task.setIcon(ICONPATH+task.getIcon());
        task.setRemainNum(task.getTotalNum());
        taskService.addTask(task);
        return "forward:/page/toList";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @RequestMapping("/getTaskList")
    @ResponseBody
    public JSONObject  getConfigList(String appName)
    {
        JSONObject result=new JSONObject();
        List<Task> taskList=null;
        if(appName.equals("all"))
        {
            taskList = taskService.getTaskList();
        }else
        {
            taskList = taskService.selectByAppName(appName);
        }

        result.put("taskList",taskList);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @RequestMapping("/updateTask")
    public String updateTask(final Task task)
    {
        taskService.updateById(task);
        return "forward:/page/toList";
    }


    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @RequestMapping("/deleteTask")
    @ResponseBody
    public JSONObject deleteTask(final int id)
    {
        JSONObject result = new JSONObject();
        String res;
        String mes;
        if (taskService.deleteById(id)) {
            res = "success";
            mes = "删除成功！";
            result.put("mes", mes);
            result.put("res", res);
            return result;
        }
        res = "failed";
        mes = "删除失败";
        result.put("mes", mes);
        result.put("res", res);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @RequestMapping("/takeEffectTask")
    @ResponseBody
    public JSONObject takeEffectTask(final int id)
    {
        JSONObject result=new JSONObject();
        String res;
        String mes;
        HashMap map=new HashMap(16);
        map.put("taskId",id);
        try {
            httpAPIService.doGet(SERVERURL,map);
            res="success";
            mes="任务已生效！";
            result.put("mes",mes);
            result.put("res",res);
            return result;
        } catch (Exception e) {
            logger.error("任务生效操作出异常了:"+e.getMessage());
        }
        res="failed";
        mes="操作失败";
        result.put("mes",mes);
        result.put("res",res);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @RequestMapping(value = "/upload")
    @ResponseBody
    public JSONObject upload(MultipartFile file) {
        JSONObject result=new JSONObject();
            String mes;
            String res;
        try {
            if (file.isEmpty()) {
                res="failed";
                mes="文件为空";
                result.put("mes",mes);
                result.put("res",res);
                return result;
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            logger.info("上传的文件名为：" + fileName);
            // 设置文件存储路径
            //服务器路径
            //String filePath = "/home/qkwall/appIcon/";
            //本地路径
            String filePath = "F:\\appIcon\\";
            String path = filePath + fileName;
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            // 文件写入
            file.transferTo(dest);
            String fileNameAndPath="/appIcon/"+fileName;

            res="success";
            mes="上传成功";
            result.put("mes",mes);
            result.put("res",res);
            result.put("path",fileNameAndPath);
            return result;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        res="failed";
        mes="上传失败";
        result.put("mes",mes);
        result.put("res",res);
        return result;
    }
}
