package edu.njnu.eamsbe.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int commentId;
    private int userId;
    private int photoId;
    private int albumId;
    private String commentContent;
}
