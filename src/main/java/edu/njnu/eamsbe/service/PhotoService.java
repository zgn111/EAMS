package edu.njnu.eamsbe.service;

import edu.njnu.eamsbe.pojo.entity.Photo;

import java.util.List;

public interface PhotoService {

    List<Photo> getPhotoByAlbumId(int albumId);

    boolean addPhoto(Photo photo);

    boolean deletePhotoById(int photoId);

}
