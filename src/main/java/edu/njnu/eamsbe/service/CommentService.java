package edu.njnu.eamsbe.service;


import edu.njnu.eamsbe.pojo.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentByPhotoId(int photoId);

    boolean addComment(Comment comment);

    boolean deleteCommentById(int commentId);


}
