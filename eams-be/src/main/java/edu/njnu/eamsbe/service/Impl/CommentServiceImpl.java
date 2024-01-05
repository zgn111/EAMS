package edu.njnu.eamsbe.service.Impl;

import edu.njnu.eamsbe.mapper.CommentMapper;
import edu.njnu.eamsbe.pojo.entity.Comment;
import edu.njnu.eamsbe.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired(required = false)
    private CommentMapper commentMapper;

    /**
     * 根据照片id获取评论
     *
     * @param photoId 照片id
     * @return 评论列表
     */
    @Override
    public List<Comment> getCommentByPhotoId(int photoId) {
        return commentMapper.findCommentByPhotoId(photoId);
    }

    /**
     * 添加评论
     *
     * @param comment 评论
     * @return 是否添加成功
     */
    @Override
    public boolean addComment(Comment comment) {
        return commentMapper.addComment(comment) > 0;
    }

    /**
     * 根据评论id删除评论
     *
     * @param commentId 评论id
     * @return 是否删除成功
     */
    @Override
    public boolean deleteCommentById(int commentId) {
        return commentMapper.deleteCommentById(commentId) > 0;
    }
}
