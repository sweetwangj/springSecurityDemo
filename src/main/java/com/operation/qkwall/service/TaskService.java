package com.operation.qkwall.service;

import com.operation.qkwall.entity.Task;
import com.operation.qkwall.mapper.TaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    TaskMapper taskMapper;

    /**
     * 添加任务
     * @param task
     */
    public void addTask(final Task task)
    {
        taskMapper.insert(task);
        logger.info("添加了一项任务"+task);
    }

    /**
     * 查询任务列表
     */
    public List<Task> getTaskList()
    {
        final List<Task> taskList = taskMapper.select();
        return taskList;
    }

    /**
     * 根据id查任务
     */
    public Task selectById(final int id)
    {
        final Task task = taskMapper.selectById(id);
        logger.info("task："+task);
        return task;
    }

    /**
     * 删除
     */
    public boolean deleteById(final int id)
    {
        final int num = taskMapper.deleteById(id);
        if(num>0)
        {
            logger.info("删除了一条任务");
            return true;
        }
        return false;
    }

    /**
     * 更新任务信息
     */
    public void updateById(final Task task)
    {
        taskMapper.update(task);
        logger.info("更新任务信息");
    }

    /**
     * 更新任务信息
     */
    public List<Task> selectByAppName(final String appName)
    {
        final List<Task> task = taskMapper.selectByAppName(appName);
        logger.info("当前记录"+task);
        return task;
    }

}
