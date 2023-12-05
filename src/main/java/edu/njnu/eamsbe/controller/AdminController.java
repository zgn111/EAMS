package edu.njnu.eamsbe.controller;


import edu.njnu.eamsbe.pojo.entity.Album;
import edu.njnu.eamsbe.pojo.entity.Photo;
import edu.njnu.eamsbe.pojo.entity.User;
import edu.njnu.eamsbe.service.AdminService;
import edu.njnu.eamsbe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired(required = false)
    private AdminService adminService;

    /**
     * 获取所有用户信息
     *
     * @return 所有用户信息
     */
    @PostMapping("/findAllUser")
    public Result<List<User>> findAllUser() {
        return Result.getSuccessResult(adminService.getAllUsers());
    }

    /**
     * 获取用户的所有相册
     *
     * @param userId 用户id
     * @return 用户的所有相册
     */
    @PostMapping("/findAllAlbums")
    public Result<List<Album>> findAllAlbum(int userId) {
        return Result.getSuccessResult(adminService.getAllAlbums(userId));
    }

    /**
     * 获取相册的所有照片
     *
     * @param albumId 相册id
     * @return 相册的所有照片
     */
    @PostMapping("/findAllPhotos")
    public Result<List<Photo>> findAllPhoto(int albumId) {
        return Result.getSuccessResult(adminService.getAllPhotos(albumId));
    }


    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return 是否删除成功
     */
    @PostMapping("/deleteUserById")
    public Result<Boolean> deleteUserById(int userId) {
        return Result.getSuccessResult(adminService.deleteUserById(userId));
    }

    /**
     * 禁用用户
     *
     * @param userId 用户id
     * @return 是否禁用成功
     */
    @PostMapping("/disableUserById")
    public Result<Boolean> disableUserById(int userId) {
        return Result.getSuccessResult(adminService.disableUserById(userId));
    }

}
