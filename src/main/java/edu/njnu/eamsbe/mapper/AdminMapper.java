package edu.njnu.eamsbe.mapper;

import edu.njnu.eamsbe.pojo.entity.Album;
import edu.njnu.eamsbe.pojo.entity.Photo;
import edu.njnu.eamsbe.pojo.entity.User;

import java.util.List;

public interface AdminMapper {

    List<User> findAllUsers(int adminId);

    int deleteUserById(int userId);

    int setUserStatusById(int userId, boolean status);


}
