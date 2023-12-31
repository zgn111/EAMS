package edu.njnu.eamsbe.controller;


import edu.njnu.eamsbe.pojo.entity.Photo;
import edu.njnu.eamsbe.pojo.entity.VO.PhotoVO;
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
@CrossOrigin("http://localhost:5173")
public class PhotoController {
    @Autowired(required = false)
    private PhotoService photoService;

    /**
     * 根据相册id获取相册中的所有照片
     */
    @PostMapping("/getPhotoByAlbumId")
    public Result<List<PhotoVO>> getPhotoByAlbumId(int albumId) {
        return Result.getSuccessResult(photoService.getPhotoByAlbumId(albumId));
    }

    /**
     * 添加照片
     */
    @PostMapping(value = "/addPhoto")
    public Result<Boolean> addPhoto(@RequestParam MultipartFile file, @RequestParam int userId, @RequestParam int albumId, @RequestParam int adminId) {
        Photo photo = new Photo();
        System.out.println("photo = " + photo);
        System.out.println("userId = " + userId);
        System.out.println("albumId = " + albumId);
        System.out.println("adminId = " + adminId);
        // 获取前端传来的文件
        try {
            String photoUrl = savePhoto(file);
            photo.setPhotoUrl(photoUrl);
            photo.setPhotoName(file.getOriginalFilename());
            photo.setUserId(userId);
            photo.setAlbumId(albumId);
            photo.setAdminId(adminId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result.getSuccessResult(photoService.addPhoto(photo));
    }

    public String savePhoto(MultipartFile file) throws IOException {

        //指定服务器的文件夹
        String folderPath = "D:\\GitHub\\PicMe\\img";
        //获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("fileName = " + fileName);
        //构建文件存储路径
        String filePath = folderPath + "\\" + fileName;
        File file1 = new File(filePath);
        //保存文件
        file.transferTo(file1.getAbsoluteFile());
        //返回图片的url
        return "http://localhost:8080/photos/" + fileName;
    }

    /**
     * 根据照片id删除照片
     */
    @PostMapping("/deletePhotoById")
    public Result<Boolean> deletePhotoById(int photoId) {
        return Result.getSuccessResult(photoService.deletePhotoById(photoId));
    }

    @PostMapping("/updatePhotoDescription")
    public Result<Boolean> updatePhotoDescription(int photoId, String photoDescription) {
        return Result.getSuccessResult(photoService.updatePhotoDescription(photoId, photoDescription));
    }
}
