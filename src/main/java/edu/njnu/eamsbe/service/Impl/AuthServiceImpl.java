package edu.njnu.eamsbe.service.Impl;

import edu.njnu.eamsbe.mapper.AuthMapper;
import edu.njnu.eamsbe.pojo.entity.User;
import edu.njnu.eamsbe.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired(required = false)
    private AuthMapper authMapper;

    /**
     * 用户登录
     *
     * @param user 用户信息
     * @return 是否登录成功
     */
    @Override
    public boolean login(User user) {
        //查询数据库中是否存在该用户
        List<User> result = authMapper.findLoginUser(user);
        //如果查询结果为空，则返回false
        return !result.isEmpty();
    }

    @Override
    public boolean register(User user) {
        //查询数据库中是否存在该用户
        List<User> result = authMapper.findRegisterUser(user);
        //如果查询结果为空，则添加该用户
        if (result.isEmpty()) {
            return authMapper.insertUser(user) == 1;
        } else {
            return false;
        }

    }
}
