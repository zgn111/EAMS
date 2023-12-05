package edu.njnu.eamsbe.controller;


import edu.njnu.eamsbe.pojo.entity.Photo;
import edu.njnu.eamsbe.service.PhotoService;
import edu.njnu.eamsbe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {
    @Autowired(required = false)
    private PhotoService photoService;

    /**
     * 根据相册id获取相册中的所有照片
     */
    @PostMapping("/getPhotoByAlbumId")
    public Result<List<Photo>> getPhotoByAlbumId(int albumId) {
        return Result.getSuccessResult(photoService.getPhotoByAlbumId(albumId));
    }

    /**
     * 添加照片
     */
    @PostMapping("/addPhoto")
    public Result<Boolean> addPhoto(@RequestParam("file") MultipartFile file, @RequestBody Photo photo) {

        // 获取前端传来的文件
        try {
            String photoUrl = savePhoto(file);
            photo.setPhotoUrl(photoUrl);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result.getSuccessResult(photoService.addPhoto(photo));
    }

    public String savePhoto(MultipartFile file) throws IOException {

        //指定服务器的文件夹
        String folderPath = "/path/to/folder";
        //获取文件名
        String fileName = file.getOriginalFilename();
        //构建文件存储路径
        String filePath = folderPath + fileName;
        //保存文件
        file.transferTo(new File(filePath));
        //返回图片的url
        return "upload-images" + fileName;

    }

    /**
     * 根据照片id删除照片
     */
    @PostMapping("/deletePhotoById")
    public Result<Boolean> deletePhotoById(int photoId) {
        return Result.getSuccessResult(photoService.deletePhotoById(photoId));
    }

}
