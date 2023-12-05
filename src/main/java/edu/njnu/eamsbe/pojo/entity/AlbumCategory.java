package edu.njnu.eamsbe.pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumCategory {
    private int categoryId;
    private String categoryPath;
    private String categoryName;
    private Date categoryCreateDate;
}
