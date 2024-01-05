package edu.njnu.eamsbe.mapper;


import edu.njnu.eamsbe.pojo.entity.Album;
import edu.njnu.eamsbe.pojo.entity.VO.AlbumVO;

import java.util.List;

public interface AlbumMapper {

    List<AlbumVO> findAllAlbums(int categoryId);

    int addAlbum(Album album);

    int deleteAlbumById(int albumId);

    int updateAlbumName(int albumId, String albumName);


}
