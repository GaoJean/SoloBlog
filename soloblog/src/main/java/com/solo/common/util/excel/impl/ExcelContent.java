/**
 * Copyright (c) www.danlu.com 2016 All Rights Reserved.
 */
package com.solo.common.util.excel.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: GaoJean
 * @ClassName: ExcelContent
 * @Description: TODO
 * @date: 2018/7/29
 */
public class ExcelContent {
    private List<String>       title   = new ArrayList<String>();
    private List<List<Bubble>> complexTitle = new ArrayList<List<Bubble>>();
    private List<String>       headers = new ArrayList<String>();
    private List<String>       footers = new ArrayList<String>();
    private List<List<String>> content = new ArrayList<List<String>>();
    private List<List<List<Bubble>>> complexContent = new ArrayList<List<List<Bubble>>>();
    private Integer 		   contentSize = 0;
    private Integer            offset;
    //报表导出，商品总数量总金额
    private Map<String,String> totalNumAndPrice = new HashMap<String,String>(); 
    /** 报表最后一行展示各列统计信息 **/
    private Map<Integer,String> footerMap = new HashMap<Integer,String>(); 

    /**
     * @param offset
     * The offset to set.
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * @return Returns the offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * @return Returns the title
     */
    public List<String> getTitle() {
        return title;
    }

    /**
     * @param title
     * The title to set.
     */
    public void setTitle(List<String> title) {
        this.title = title;
    }

    /**
     * @return Returns the headers
     */
    public List<String> getHeaders() {
        return headers;
    }

    /**
     * @param headers
     * The headers to set.
     */
    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    /**
     * @return Returns the footers
     */
    public List<String> getFooters() {
        return footers;
    }

    /**
     * @param footers
     * The footers to set.
     */
    public void setFooters(List<String> footers) {
        this.footers = footers;
    }

    /**
     * @return Returns the content
     */
    public List<List<String>> getContent() {
        return content;
    }

    /**
     * @param content
     * The content to set.
     */
    public void setContent(List<List<String>> content) {
        this.content = content;
    }

	public List<List<List<Bubble>>> getComplexContent() {
		return complexContent;
	}

	public void setComplexContent(List<List<List<Bubble>>> complexContent) {
		this.complexContent = complexContent;
	}

	public Integer getContentSize() {
		return contentSize;
	}

	public void setContentSize(Integer contentSize) {
		this.contentSize = contentSize;
	}

	public List<List<Bubble>> getComplexTitle() {
		return complexTitle;
	}

	public void setComplexTitle(List<List<Bubble>> complexTitle) {
		this.complexTitle = complexTitle;
	}

	public Map<String, String> getTotalNumAndPrice() {
		return totalNumAndPrice;
	}

	public void setTotalNumAndPrice(Map<String, String> totalNumAndPrice) {
		this.totalNumAndPrice = totalNumAndPrice;
	}

	public Map<Integer,String> getFooterMap() {
		return footerMap;
	}
	
	/** 
	 * 报表最后一行展示各列统计信息<br>
	 * key：列数<br>
	 * value：单元格信息
	 **/
	public void setFooterMap(Map<Integer,String> footerMap) {
		this.footerMap = footerMap;
	}
	
}
