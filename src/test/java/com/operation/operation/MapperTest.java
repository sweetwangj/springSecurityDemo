package com.operation.operation;

import com.operation.qkwall.OperationApplication;
import com.operation.qkwall.entity.Task;
import com.operation.qkwall.mapper.TaskMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OperationApplication.class)
public class MapperTest {

    @Autowired
    TaskMapper taskMapper;

    @Test
    public void insert()
    {
        Task task=new Task();
        task.setAppName("aaa");
        task.setDownloadDescription("");
        task.setAppType(1);
        taskMapper.insert(task);
    }

    @Test
    public void select()
    {
        final List<Task> select = taskMapper.select();
        select.forEach(s-> System.out.println(s));
    }
}
