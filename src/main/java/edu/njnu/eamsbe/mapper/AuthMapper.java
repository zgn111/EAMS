package edu.njnu.eamsbe.mapper;

import edu.njnu.eamsbe.pojo.entity.User;

import java.util.List;

public interface AuthMapper {

    List<User> findUser(User user);

    int insertUser(User user);

}
