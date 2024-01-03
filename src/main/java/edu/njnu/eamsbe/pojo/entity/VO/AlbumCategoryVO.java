package edu.njnu.eamsbe.pojo.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumCategoryVO {
    private int categoryId;
    private String categoryName;
    private String categoryPath;
    private Date categoryCreateDate;
    private int albumCount;
}
