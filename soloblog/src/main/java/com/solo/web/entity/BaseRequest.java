package com.solo.web.entity;



import com.solo.common.constant.Constant;

import java.io.Serializable;


/**
 * Created by GaoJean on 2017/10/26.
 */
public class BaseRequest  implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -1475269915925595347L;

    /**
     * 页码
     */
    public int page = Constant.PAGE_CURRENT;

    /**
     * 每页行数
     */
    public int rows = Constant.PAGE_SIZE;


    public int getPage() {
        if(this.page < 1) {
            return Constant.PAGE_CURRENT;
        } else {
            return this.page;
        }
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        if(this.rows < 1) {
            return Constant.PAGE_SIZE;
        } else {
            return this.rows;
        }
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

}
