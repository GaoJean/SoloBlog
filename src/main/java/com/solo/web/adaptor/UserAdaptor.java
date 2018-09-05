package com.solo.web.adaptor;

import com.solo.dao.entity.Role;
import com.solo.dao.entity.User;
import com.solo.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Jianjian on 2018/5/7.
 */
@Component
public class UserAdaptor {

    @Autowired
    private UserService userService;

    public String getUserName() {

        List<Role> roleList = userService.getAllRole();
        for(Role role : roleList){
            System.out.println(role);
        }
        User user = userService.selectByPrimaryKey(1);
        if(user == null){
            return "";
        }
        return user.getUserName();
    }
}
