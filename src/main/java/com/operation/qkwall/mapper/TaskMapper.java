package com.operation.qkwall.mapper;

import com.operation.qkwall.entity.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {
    /**
     * 添加任务
     * @param task
     * @return
     */
    int insert(Task task);

    /**
     * 更新任务信息
     * @param task
     * @return
     */
    int update(Task task);

    /**
     * 查询全部任务
     * @return
     */
    List<Task> select();

    /**
     * 查询单个任务
     * @param id
     * @return
     */
    Task selectById(int id);

    /**
     * 删除任务
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 根据名字查任务
     * @param appName
     * @return
     */
    List<Task> selectByAppName(String appName);

}
