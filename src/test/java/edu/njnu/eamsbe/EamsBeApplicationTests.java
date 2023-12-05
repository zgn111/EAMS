package edu.njnu.eamsbe;

import edu.njnu.eamsbe.mapper.AlbumCategoryMapper;
import edu.njnu.eamsbe.mapper.AuthMapper;
import edu.njnu.eamsbe.mapper.PhotoMapper;
import edu.njnu.eamsbe.pojo.entity.AlbumCategory;
import edu.njnu.eamsbe.pojo.entity.Photo;
import edu.njnu.eamsbe.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class EamsBeApplicationTests {


    @Autowired(required = false)
    private AuthService authService;
    @Autowired(required = false)
    private AuthMapper authMapper;
    @Autowired(required = false)
    private AlbumCategoryMapper albumCategoryMapper;

    @Autowired(required = false)
    private PhotoMapper photoMapper;
    @Test
    void contextLoads() {

    }

    @Test
    public void test() {
        Photo photo = new Photo();
        photo.setPhotoId(1);
        photo.setAlbumId(1);
        photo.setPhotoName("test");
        photo.setPhotoUrl("test");
        photo.setPhotoDescription("test");
        photo.setCover(false);
        photo.setUserId(1);
        photo.setAdminId(1);
        photoMapper.addPhoto(photo);


    }

}
