package edu.njnu.eamsbe.mapper;

import edu.njnu.eamsbe.pojo.entity.Comment;

import java.util.List;

public interface CommentMapper {
    List<Comment> findCommentByPhotoId(int photoId);

    int addComment(Comment comment);

    int deleteCommentById(int commentId);
}
