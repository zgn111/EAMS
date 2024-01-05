package edu.njnu.eamsbe.pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
    private int photoId;
    private int albumId;
    private String photoName;
    private String photoDescription;
    private String photoUrl;
    private boolean isCover=false;
    private int userId;
    private int adminId=1;
}
