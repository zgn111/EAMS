package edu.njnu.eamsbe.service;

import edu.njnu.eamsbe.pojo.entity.User;

public interface AuthService {
    /**
     * 用户登录
     *
     * @param user 用户信息
     * @return 是否登录成功
     */
    boolean login(User user);

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return 是否注册成功
     */
    boolean register(User user);
}
