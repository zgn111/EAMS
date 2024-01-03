package edu.njnu.eamsbe.service.Impl;

import edu.njnu.eamsbe.mapper.CommentMapper;
import edu.njnu.eamsbe.mapper.PhotoMapper;
import edu.njnu.eamsbe.pojo.entity.Comment;
import edu.njnu.eamsbe.pojo.entity.Photo;
import edu.njnu.eamsbe.pojo.entity.VO.PhotoVO;
import edu.njnu.eamsbe.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired(required = false)
    private PhotoMapper photoMapper;
    @Autowired(required = false)
    private CommentMapper commentMapper;

    /**
     * 根据相册id获取相册中的所有照片
     *
     * @param albumId 相册id
     * @return 相册中的所有照片
     */
    @Override
    public List<PhotoVO> getPhotoByAlbumId(int albumId) {
        List<PhotoVO> photoVOList = new ArrayList<>();
        List<Photo> photoList = photoMapper.findPhotoByAlbumId(albumId);
        for (Photo photo : photoList) {
            PhotoVO photoVO = new PhotoVO();
            photoVO.setPhotoId(photo.getPhotoId());
            photoVO.setPhotoName(photo.getPhotoName());
            photoVO.setPhotoUrl(photo.getPhotoUrl());
            photoVO.setPhotoDescription(photo.getPhotoDescription());
            photoVO.setUserId(photo.getUserId());
            photoVO.setAlbumId(photo.getAlbumId());
            photoVO.setAdminId(photo.getAdminId());
            List<Comment> commentList = commentMapper.findCommentByPhotoId(photo.getPhotoId());
            photoVO.setComments(commentList);
            photoVOList.add(photoVO);
        }
        return photoVOList;
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

        //到本地删除照片 todo
        System.out.println("photoId = " + photoId);


        return photoMapper.deletePhotoById(photoId) > 0;
    }

    /**
     * 修改照片描述
     *
     * @param photoId          照片id
     * @param photoDescription 照片描述
     * @return 是否修改成功
     */
    @Override
    public boolean updatePhotoDescription(int photoId, String photoDescription) {

        return photoMapper.updatePhotoDescription(photoId, photoDescription) > 0;
    }
}
