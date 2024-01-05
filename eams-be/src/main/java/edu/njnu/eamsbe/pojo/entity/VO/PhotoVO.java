package edu.njnu.eamsbe.pojo.entity.VO;


import edu.njnu.eamsbe.pojo.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoVO {
    private int photoId;
    private int albumId;
    private String photoName;
    private String photoDescription;
    private String photoUrl;
    private boolean isCover = false;
    private int userId;
    private int adminId = 1;
    private List<Comment> comments;
}
