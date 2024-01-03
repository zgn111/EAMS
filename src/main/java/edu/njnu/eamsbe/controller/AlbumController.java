package edu.njnu.eamsbe.controller;


import edu.njnu.eamsbe.pojo.entity.Album;
import edu.njnu.eamsbe.pojo.entity.VO.AlbumVO;
import edu.njnu.eamsbe.service.AlbumService;
import edu.njnu.eamsbe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/album")
public class AlbumController {

    @Autowired(required = false)
    private AlbumService albumService;

    /**
     * 获取某相册类别下的所有相册
     *
     * @param categoryId 相册类别id
     * @return 所有相册
     */
    @PostMapping("/getAllAlbums")
    public Result<List<AlbumVO>> getAllAlbums(int categoryId) {
        return Result.getSuccessResult(albumService.getAllAlbums(categoryId));
    }

    /**
     * 添加相册
     *
     * @param album 相册
     * @return 是否添加成功
     */
    @PostMapping("/addAlbum")
    public Result<Boolean> addAlbum(Album album) {
        System.out.println("album = " + album);
        return Result.getSuccessResult(albumService.addAlbum(album));
    }

    /**
     * 删除相册
     *
     * @param albumId 相册id
     * @return 是否删除成功
     */
    @PostMapping("/deleteAlbumById")
    public Result<Boolean> deleteAlbumById(int albumId) {
        return Result.getSuccessResult(albumService.deleteAlbumById(albumId));
    }

    @PostMapping("/updateAlbumName")
    public Result<Boolean> updateAlbumName(int albumId, String albumName) {
        return Result.getSuccessResult(albumService.updateAlbumName(albumId, albumName));
    }


}
