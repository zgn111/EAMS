package edu.njnu.eamsbe.service.Impl;

import edu.njnu.eamsbe.mapper.AlbumMapper;
import edu.njnu.eamsbe.pojo.entity.Album;
import edu.njnu.eamsbe.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired(required = false)
    private AlbumMapper albumMapper;

    /**
     * 获取所有相册
     * @return 所有相册
     */
    @Override
    public List<Album> getAllAlbum() {
        return albumMapper.findAllAlbum();
    }

    /**
     * 添加相册
     * @param album 相册
     * @return 是否添加成功
     */
    @Override
    public boolean addAlbum(Album album) {
        return albumMapper.addAlbum(album) > 0;
    }

    /**
     * 删除相册
     * @param albumId 相册id
     * @return 是否删除成功
     */
    @Override
    public boolean deleteAlbumById(int albumId) {
        return albumMapper.deleteAlbumById(albumId) > 0;
    }
}
