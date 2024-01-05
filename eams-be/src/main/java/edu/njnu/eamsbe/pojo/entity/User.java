package edu.njnu.eamsbe.pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private Date registerDate=new Date();
    private int adminId=1;
    private boolean isDisabled=false;


}
