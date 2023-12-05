package edu.njnu.eamsbe.mapper;


import edu.njnu.eamsbe.pojo.entity.Album;

import java.util.List;

public interface AlbumMapper {

    List<Album> findAllAlbum();

    int addAlbum(Album album);

    int deleteAlbumById(int albumId);


}
