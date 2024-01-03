package edu.njnu.eamsbe.controller;


import edu.njnu.eamsbe.pojo.entity.AlbumCategory;
import edu.njnu.eamsbe.pojo.entity.VO.AlbumCategoryVO;
import edu.njnu.eamsbe.service.AlbumCategoryService;
import edu.njnu.eamsbe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/getAllAlbumCategories")
    public Result<List<AlbumCategoryVO>> getAllAlbumCategories() {
        return Result.getSuccessResult(albumCategoryService.getAllAlbumCategory());
    }

    @PostMapping("/addAlbumCategory")
    public Result<Boolean> addAlbumCategory(String albumCategoryName) {
        return Result.getSuccessResult(albumCategoryService.addAlbumCategory(albumCategoryName));
    }

    @PostMapping("/deleteAlbumCategoryById")
    public Result<Boolean> deleteAlbumCategoryById(int categoryId) {
        return Result.getSuccessResult(albumCategoryService.deleteAlbumCategoryById(categoryId));
    }
}
