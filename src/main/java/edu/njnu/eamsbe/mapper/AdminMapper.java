package edu.njnu.eamsbe.mapper;

import edu.njnu.eamsbe.pojo.entity.Album;
import edu.njnu.eamsbe.pojo.entity.Photo;
import edu.njnu.eamsbe.pojo.entity.User;

import java.util.List;

public interface AdminMapper {

    List<User> findAllUsers();

    List<Album> findAllAlbums(int userId);

    List<Photo> findAllPhotos(int albumId);

    int deleteUserById(int userId);

    int disableUserById(int userId);


}
