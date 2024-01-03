package edu.njnu.eamsbe.service;

import edu.njnu.eamsbe.pojo.entity.Photo;
import edu.njnu.eamsbe.pojo.entity.VO.PhotoVO;

import java.util.List;

public interface PhotoService {

    List<PhotoVO> getPhotoByAlbumId(int albumId);

    boolean addPhoto(Photo photo);

    boolean deletePhotoById(int photoId);

    boolean updatePhotoDescription(int photoId, String photoDescription);

}
