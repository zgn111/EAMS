package edu.njnu.eamsbe.controller;


import edu.njnu.eamsbe.pojo.entity.Photo;
import edu.njnu.eamsbe.service.PhotoService;
import edu.njnu.eamsbe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {
    @Autowired(required = false)
    private PhotoService photoService;

    /**
     * 根据相册id获取相册中的所有照片
     */
    @RequestMapping("/getPhotoByAlbumId")
    public Result<List<Photo>> getPhotoByAlbumId(int albumId) {
        return Result.getSuccessResult(photoService.getPhotoByAlbumId(albumId));
    }

    /**
     * 添加照片
     */
    @RequestMapping("/addPhoto")
    public Result<Boolean> addPhoto(Photo photo) {
        return Result.getSuccessResult(photoService.addPhoto(photo));
    }

    /**
     * 根据照片id删除照片
     */
    @RequestMapping("/deletePhotoById")
    public Result<Boolean> deletePhotoById(int photoId) {
        return Result.getSuccessResult(photoService.deletePhotoById(photoId));
    }
}
