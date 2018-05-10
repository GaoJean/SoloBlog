package com.solo.web.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by GaoJean on 2017/10/26.
 */
@Getter
@Setter
public class BaseResponse implements Serializable{
    /**
     * 成功与否 0-成功 1-失败 其他-由具体接口定义
     */
	@ApiModelProperty(value="业务成功code")
    private String success;


}
