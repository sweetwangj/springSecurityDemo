package com.operation.qkwall.mapper;
import com.operation.qkwall.entity.Admin;
import java.util.List;
public interface AdminMapper {
    /**
     * 更新
     * @param admin
     * @return
     */
        int update(Admin admin);

    /**
     * 添加
     * @param admin
     * @return
     */
        Long insert(Admin admin);

    /**
     * 名字查找
     * @param username
     * @return
     */
        Admin findUserByName(String username);

    /**
     * 所有人
     * @return
     */
    List<Admin> select();

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteById(int id);

    }

