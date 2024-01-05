package edu.njnu.eamsbe.controller;


import edu.njnu.eamsbe.pojo.entity.Comment;
import edu.njnu.eamsbe.service.CommentService;
import edu.njnu.eamsbe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin("http://localhost:5173")
public class CommentController {
    @Autowired(required = false)
    private CommentService commentService;

    @PostMapping("/getCommentByPhotoId")
    public Result<List<Comment>> getCommentByPhotoId(int photoId) {
        return Result.getSuccessResult(commentService.getCommentByPhotoId(photoId));
    }

    @PostMapping("/addComment")
    public Result<Boolean> addComment(Comment comment) {
        return Result.getSuccessResult(commentService.addComment(comment));
    }

    @PostMapping("/deleteCommentById")
    public Result<Boolean> deleteCommentById(int commentId) {
        return Result.getSuccessResult(commentService.deleteCommentById(commentId));
    }

}
