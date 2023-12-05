package edu.njnu.eamsbe.service;


import edu.njnu.eamsbe.pojo.entity.Album;

import java.util.List;

public interface AlbumService {

    /**
     * 获取所有相册
     *
     * @return 所有相册
     */
    List<Album> getAllAlbum();

    /**
     * 添加相册
     *
     * @param album 相册
     * @return 是否添加成功
     */
    boolean addAlbum(Album album);

    /**
     * 删除相册
     *
     * @param albumId 相册id
     * @return 是否删除成功
     */
    boolean deleteAlbumById(int albumId);

}
