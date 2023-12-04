package edu.njnu.eamsbe.mapper;

import edu.njnu.eamsbe.pojo.entity.User;

import java.util.List;

public interface AuthMapper {

    /**
     * @param user 用户信息
     * @return 是否登录成功
     */
   List<User> findLoginUser(User user);

   List<User> findRegisterUser(User user);

   int insertUser(User user);

}
