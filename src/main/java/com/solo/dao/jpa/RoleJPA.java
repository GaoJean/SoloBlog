package com.solo.dao.jpa;

import com.solo.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * Created by Jianjian on 2018/5/9.
 */
public interface RoleJPA extends JpaRepository<Role,Long>,JpaSpecificationExecutor<Role>,Serializable {
}

