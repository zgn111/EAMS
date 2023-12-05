package edu.njnu.eamsbe.service;

import edu.njnu.eamsbe.pojo.entity.AlbumCategory;

import java.util.List;

public interface AlbumCategoryService {

    /**
     * 获取所有相册分类
     *
     * @return 所有相册分类
     */
    List<AlbumCategory> getAllAlbumCategory();

    /**
     * 添加相册分类
     *
     * @param albumCategory 相册分类
     * @return 是否添加成功
     */
    boolean addAlbumCategory(AlbumCategory albumCategory);


    /**
     * 删除相册分类
     *
     * @param categoryId 相册分类id
     * @return 是否删除成功
     */
    boolean deleteAlbumCategoryById(int categoryId);
}
