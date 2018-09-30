package com.solo.web.entity.response.user;

import com.solo.web.entity.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Jianjian on 2018/5/7.
 */
@Getter
@Setter
@ToString
public class LoginResponse extends BaseResponse {

    private String username;
    private String userId;
    private String nikename;
    private Integer status;
}
