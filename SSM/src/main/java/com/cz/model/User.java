package com.cz.model;

import com.cz.util.IDGeneratorUtil;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.IdGenerator;

import java.util.Date;

@Data
@Repository
public class User {
    private String id;
    private String userName;
    private String password;
    private String pwdKey;
    private String mobile;
    private Date createTime;
    public User(){
        id = IDGeneratorUtil.generateID();
    }
}
