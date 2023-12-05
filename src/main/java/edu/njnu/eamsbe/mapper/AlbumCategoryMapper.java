package edu.njnu.eamsbe.mapper;

import edu.njnu.eamsbe.pojo.entity.AlbumCategory;

import java.util.List;

public interface AlbumCategoryMapper {

    List<AlbumCategory> findAllAlbumCategory();

    int insertAlbumCategory(AlbumCategory albumCategory);

    int deleteAlbumCategoryById(int categoryId);
}
