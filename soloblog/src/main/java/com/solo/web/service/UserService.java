package com.solo.web.service;

import com.solo.dao.entity.Role;
import com.solo.dao.entity.User;

import java.util.List;

/**
 * Created by Jianjian on 2018/5/7.
 */
public interface UserService {

    public User selectByPrimaryKey(Integer userId);

    public List<Role> getAllRole();
}
