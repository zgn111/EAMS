package edu.njnu.eamsbe.service.Impl;

import edu.njnu.eamsbe.mapper.AlbumCategoryMapper;
import edu.njnu.eamsbe.pojo.entity.AlbumCategory;
import edu.njnu.eamsbe.pojo.entity.VO.AlbumCategoryVO;
import edu.njnu.eamsbe.service.AlbumCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AlbumCategoryServiceImpl implements AlbumCategoryService {
    @Autowired(required = false)
    private AlbumCategoryMapper albumCategoryMapper;


    /**
     * 获取所有相册分类
     *
     * @return 相册分类列表
     */
    @Override
    public List<AlbumCategoryVO> getAllAlbumCategory() {

        return albumCategoryMapper.findAllAlbumCategory();
    }

    /**
     * 添加相册分类
     *
     * @param albumCategoryName 相册分类
     * @return 添加成功返回true，否则返回false
     */
    @Override
    public boolean addAlbumCategory(String albumCategoryName) {
        AlbumCategory albumCategory = new AlbumCategory();
        albumCategory.setCategoryName(albumCategoryName);
        albumCategory.setCategoryCreateDate(new Date());
        albumCategory.setCategoryPath("/album/"+albumCategoryName);
        return albumCategoryMapper.insertAlbumCategory(albumCategory) > 0;

    }

    /**
     * 删除相册分类
     *
     * @param categoryId 相册分类id
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean deleteAlbumCategoryById(int categoryId) {
        return albumCategoryMapper.deleteAlbumCategoryById(categoryId) > 0;

    }
}
