package edu.njnu.eamsbe.service;

import edu.njnu.eamsbe.pojo.entity.Album;
import edu.njnu.eamsbe.pojo.entity.Photo;
import edu.njnu.eamsbe.pojo.entity.User;

import java.util.List;

public interface AdminService {

    /**
     * 获取所有用户信息
     *
     * @return 所有用户信息
     */
    List<User> getAllUsers(int adminId);

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return 是否删除成功
     */
    boolean deleteUserById(int userId);

    /**
     * 禁用或启用用户
     *
     * @param userId 用户id
     * @param status 用户状态
     * @return 是否禁用或启用成功
     */
    boolean setUserStatusById(int userId, boolean status);


}

