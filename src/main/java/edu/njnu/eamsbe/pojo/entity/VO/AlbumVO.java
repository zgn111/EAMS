package edu.njnu.eamsbe.pojo.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumVO {
    private int albumId;
    private String albumName;
    private String albumDescription;
    private String albumCoverUrl;
    private int categoryId;
    private int coverId;
    private int userId;
}
