package edu.njnu.eamsbe.service.Impl;

import edu.njnu.eamsbe.mapper.AlbumMapper;
import edu.njnu.eamsbe.pojo.entity.Album;
import edu.njnu.eamsbe.pojo.entity.VO.AlbumVO;
import edu.njnu.eamsbe.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired(required = false)
    private AlbumMapper albumMapper;


    /**
     * 获取某相册类别下的所有相册
     *
     * @param categoryId 相册类别id
     * @return 所有相册
     */
    @Override
    public List<AlbumVO> getAllAlbums(int categoryId) {

        return albumMapper.findAllAlbums(categoryId);
    }

    /**
     * 添加相册
     *
     * @param album 相册
     * @return 是否添加成功
     */
    @Override
    public boolean addAlbum(Album album) {
        return albumMapper.addAlbum(album) > 0;
    }

    /**
     * 删除相册
     *
     * @param albumId 相册id
     * @return 是否删除成功
     */
    @Override
    public boolean deleteAlbumById(int albumId) {
        return albumMapper.deleteAlbumById(albumId) > 0;
    }

    /**
     * 修改相册名
     * @param albumId 相册id
     * @param albumName 相册名
     * @return 是否修改成功
     */
    @Override
    public boolean updateAlbumName(int albumId, String albumName) {
        return albumMapper.updateAlbumName(albumId, albumName) > 0;
    }
}
