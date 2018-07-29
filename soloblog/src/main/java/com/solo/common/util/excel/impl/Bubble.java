package com.solo.common.util.excel.impl;


/**
 * 细胞组
 */
public class Bubble {

	private String content; // 内容
	private int row = 0; // 占有行
	private int col = 0; //占有列
	private int rowstart; //合并行开始处
	private int colstart;  //合并列开始处
	
	public Bubble(String content, int row) {
		this.content = content;
		this.row = row;
	}

	public Bubble(String content, int row ,int col ,int rowstart ,int colstart) {
		this.content = content;
		this.row = row;
		this.col = col;
		this.rowstart = rowstart;
		this.colstart = colstart;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRowstart() {
		return rowstart;
	}

	public void setRowstart(int rowstart) {
		this.rowstart = rowstart;
	}

	public int getColstart() {
		return colstart;
	}

	public void setColstart(int colstart) {
		this.colstart = colstart;
	}

}
