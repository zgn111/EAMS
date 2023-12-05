package edu.njnu.eamsbe.service.Impl;

import edu.njnu.eamsbe.mapper.PhotoMapper;
import edu.njnu.eamsbe.pojo.entity.Photo;
import edu.njnu.eamsbe.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired(required = false)
    private PhotoMapper photoMapper;

    /**
     * 根据相册id获取相册中的所有照片
     *
     * @param albumId 相册id
     * @return 相册中的所有照片
     */
    @Override
    public List<Photo> getPhotoByAlbumId(int albumId) {
        return photoMapper.findPhotoByAlbumId(albumId);
    }

    /**
     * 添加照片
     *
     * @param photo 照片
     * @return 是否添加成功
     */
    @Override
    public boolean addPhoto(Photo photo) {
        return photoMapper.addPhoto(photo) > 0;
    }

    /**
     * 根据照片id删除照片
     *
     * @param photoId 照片id
     * @return 是否删除成功
     */
    @Override
    public boolean deletePhotoById(int photoId) {
        return photoMapper.deletePhotoById(photoId) > 0;
    }
}
