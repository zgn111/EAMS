package edu.njnu.eamsbe.controller;


import edu.njnu.eamsbe.pojo.entity.AlbumCategory;
import edu.njnu.eamsbe.service.AlbumCategoryService;
import edu.njnu.eamsbe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/albumCategory")
public class AlbumCategoryController {

    @Autowired(required = false)
    private AlbumCategoryService albumCategoryService;

    /**
     * 获取所有相册分类
     *
     * @return 相册分类列表
     */
    @PostMapping("/getAllAlbumCategories")
    public Result<List<AlbumCategory>> getAllAlbumCategories() {
        return Result.getSuccessResult(albumCategoryService.getAllAlbumCategory());
    }

    @PostMapping("/addAlbumCategory")
    public Result<Boolean> addAlbumCategory(AlbumCategory albumCategory) {
        return Result.getSuccessResult(albumCategoryService.addAlbumCategory(albumCategory));
    }

    @PostMapping("/deleteAlbumCategoryById")
    public Result<Boolean> deleteAlbumCategoryById(int categoryId) {
        return Result.getSuccessResult(albumCategoryService.deleteAlbumCategoryById(categoryId));
    }
}
