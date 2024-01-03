package edu.njnu.eamsbe.service;


import edu.njnu.eamsbe.pojo.entity.Album;
import edu.njnu.eamsbe.pojo.entity.VO.AlbumVO;

import java.util.List;

public interface AlbumService {

    /**
     * 获取某相册类别下的所有相册
     * @param categoryId 相册类别id
     * @return 所有相册
     */
    List<AlbumVO> getAllAlbums(int categoryId);

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

    /**
     * 修改相册名
     *
     * @param albumId 相册id
     * @param albumName 相册名
     * @return 是否修改成功
     */
    boolean updateAlbumName(int albumId, String albumName);

}
