package edu.njnu.eamsbe.mapper;

import edu.njnu.eamsbe.pojo.entity.Photo;

import java.util.List;

public interface PhotoMapper {
    List<Photo> findPhotoByAlbumId(int albumId);

    int addPhoto(Photo photo);

    int deletePhotoById(int photoId);

}
