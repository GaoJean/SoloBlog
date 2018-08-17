package com.solo.web.entity.request.user;

import com.solo.web.entity.BaseRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Jianjian on 2018/5/7.
 */
@Getter
@Setter
@ToString
public class LoginRequest extends BaseRequest {

    private String username;

    private String password;
    private Long id ;

}
