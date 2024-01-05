package edu.njnu.eamsbe.pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    private int albumId;
    private int userId;
    private int adminId;
    private int categoryId;
    private String albumName;
    private String albumDescription;
    private int coverId;
}
