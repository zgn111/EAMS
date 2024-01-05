package edu.njnu.eamsbe.mapper;

import edu.njnu.eamsbe.pojo.entity.AlbumCategory;
import edu.njnu.eamsbe.pojo.entity.VO.AlbumCategoryVO;

import java.util.List;

public interface AlbumCategoryMapper {

    List<AlbumCategoryVO> findAllAlbumCategory();

    int insertAlbumCategory(AlbumCategory albumCategory);

    int deleteAlbumCategoryById(int categoryId);
}
