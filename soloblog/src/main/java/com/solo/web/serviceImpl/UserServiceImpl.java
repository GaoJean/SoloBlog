package com.solo.web.serviceImpl;

import com.solo.dao.entity.Role;
import com.solo.dao.entity.User;
import com.solo.dao.jpa.RoleJPA;
import com.solo.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jianjian on 2018/5/7.
 */
@Service("userService")
public class UserServiceImpl  implements UserService{

    @Autowired
    private RoleJPA roleJPA;
    @Override
    public User selectByPrimaryKey(Integer userId) {
        return null;
    }

    @Override
    public List<Role> getAllRole() {
        return roleJPA.findAll();
    }
}
