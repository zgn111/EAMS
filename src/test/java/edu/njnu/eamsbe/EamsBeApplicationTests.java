package edu.njnu.eamsbe;

import edu.njnu.eamsbe.mapper.AlbumCategoryMapper;
import edu.njnu.eamsbe.mapper.AuthMapper;
import edu.njnu.eamsbe.mapper.PhotoMapper;
import edu.njnu.eamsbe.pojo.entity.Album;
import edu.njnu.eamsbe.pojo.entity.AlbumCategory;
import edu.njnu.eamsbe.pojo.entity.Photo;
import edu.njnu.eamsbe.pojo.entity.User;
import edu.njnu.eamsbe.service.AlbumCategoryService;
import edu.njnu.eamsbe.service.AlbumService;
import edu.njnu.eamsbe.service.AuthService;
import edu.njnu.eamsbe.service.CommentService;
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
@Autowired
private AlbumCategoryService albumCategoryService;
    @Autowired(required = false)
    private PhotoMapper photoMapper;
    @Autowired(required = false)
    private CommentService commentService;
    @Test
    void contextLoads() {

    }

    @Test
    public void test() {

        commentService.getCommentByPhotoId(14).forEach(System.out::println);

    }

}
