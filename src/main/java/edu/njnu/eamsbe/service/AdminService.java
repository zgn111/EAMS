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
    List<User> getAllUsers();

    /**
     * 获取用户的所有相册
     *
     * @param userId 用户id
     * @return 用户的所有相册
     */
    List<Album> getAllAlbums(int userId);

    /**
     * 获取相册的所有照片
     *
     * @param albumId 相册id
     * @return 相册的所有照片
     */
    List<Photo> getAllPhotos(int albumId);

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return 是否删除成功
     */
    boolean deleteUserById(int userId);

    /**
     * 禁用用户
     *
     * @param userId 用户id
     * @return 是否禁用成功
     */
    boolean disableUserById(int userId);


}

