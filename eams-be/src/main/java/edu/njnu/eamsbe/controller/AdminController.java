package edu.njnu.eamsbe.controller;


import edu.njnu.eamsbe.pojo.entity.Album;
import edu.njnu.eamsbe.pojo.entity.Photo;
import edu.njnu.eamsbe.pojo.entity.User;
import edu.njnu.eamsbe.service.AdminService;
import edu.njnu.eamsbe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/findAllUsers")
    public Result<List<User>> findAllUsers(int adminId) {
        return Result.getSuccessResult(adminService.getAllUsers(adminId));
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
     * 禁用或解禁用户
     *
     * @param userId 用户id
     * @return 是否禁用或解禁成功
     */
    @PostMapping("/setUserStatusById")
    public Result<Boolean> setUserStatusById(int userId,boolean status) {
        return Result.getSuccessResult(adminService.setUserStatusById(userId,status));
    }


}
