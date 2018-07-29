package com.solo.common.util.excel.impl;

import java.io.OutputStream;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class ExcelCommon {

    private static WritableWorkbook wts;

    public ExcelCommon(OutputStream os) throws Exception {
        wts = Workbook.createWorkbook(os);
    }

    public static WritableWorkbook getWritableWorkbook(OutputStream os) throws Exception {
        wts = Workbook.createWorkbook(os);
        return wts;
    }

    /**
     * create excel title
     * 
     * @param name
     * @param titleList
     * @return WritableSheet
     * @throws Exception
     */
    public static WritableSheet excelOut(String name, List titleList) throws Exception {

        WritableSheet wsheet = wts.createSheet(name, 0);

        for (int i = 0; i < titleList.size(); i++) {
            String title = (String) titleList.get(i);
            WritableCellFormat cellFormat = new WritableCellFormat();
            //默认是字体大小是10，现在改为11
            WritableFont font = new WritableFont(WritableFont.ARIAL,11);
            //设置字体;  
            //设置单元格边框
            cellFormat.setFont(font);
            cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
            cellFormat.setAlignment(Alignment.CENTRE);
            cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
            wsheet.addCell(new Label(i, 0, title,cellFormat));
        }

        return wsheet;
    }

    public static WritableSheet excelOut(String name, int sheetNum, List titleList) throws Exception {

        WritableSheet wsheet = wts.createSheet(name, sheetNum);
        for (int i = 0; i < titleList.size(); i++) {
            String title = (String) titleList.get(i);
            WritableCellFormat cellFormat = new WritableCellFormat();
            //默认是字体大小是10，现在改为11
            WritableFont font = new WritableFont(WritableFont.ARIAL,11);
            //设置字体;  
            //设置单元格边框
            cellFormat.setFont(font);
            cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
            cellFormat.setAlignment(Alignment.CENTRE);
            cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
            wsheet.addCell(new Label(i, 0, title,cellFormat));
        }

        return wsheet;
    }

    /**
     * 在第rowCount+1行创建单元格
     * @param name
     * @param sheetNum
     * @param rowCount   行号
     * @param titleList
     * @return
     * @throws Exception
     */
    public static WritableSheet excelOut(String name, int sheetNum, int rowCount, List titleList)
                                                                                                 throws Exception {
        WritableSheet wsheet = wts.createSheet(name, sheetNum);
        for (int i = 0; i < titleList.size(); i++) {
            String title = (String) titleList.get(i);
            WritableCellFormat cellFormat = new WritableCellFormat();
            //默认是字体大小是10，现在改为11
            WritableFont font = new WritableFont(WritableFont.ARIAL,11);
            //设置字体;  
            //设置单元格边框
            cellFormat.setFont(font);
            cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
            cellFormat.setAlignment(Alignment.CENTRE);
            cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
            wsheet.addCell(new Label(i, rowCount, title, cellFormat));
        }
        return wsheet;
    }

    public static WritableWorkbook getWritableWorkbook() {
        return wts;
    }

	public static WritableSheet excelOut(String name, int sheetNum, List<Bubble> categoryBubbleList,List<Bubble> titleBubbleList) throws Exception {
		WritableSheet wsheet = wts.createSheet(name, sheetNum);
		WritableCellFormat headerFormat = new WritableCellFormat();
		// 设置单元格边框
		headerFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		//默认是字体大小是10，现在改为11
        WritableFont font = new WritableFont(WritableFont.ARIAL,11);
        headerFormat.setFont(font);
        //水平居中对齐
        headerFormat.setAlignment(Alignment.CENTRE);
        //竖直方向居中对齐
        headerFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
        for (int i = 0; i < categoryBubbleList.size(); i++) {
        	Bubble bubble = categoryBubbleList.get(i);
			wsheet.mergeCells(bubble.getColstart(), bubble.getRowstart(), bubble.getColstart() + bubble.getCol(), bubble.getRowstart() + bubble.getRow());
			wsheet.addCell(new Label(bubble.getColstart(),  bubble.getRowstart(), bubble.getContent(), headerFormat));
        }
        for (int i = 0; i < titleBubbleList.size(); i++) {
        	Bubble bubble = titleBubbleList.get(i);
        	wsheet.mergeCells(bubble.getColstart(), bubble.getRowstart(), bubble.getColstart() + bubble.getCol(), bubble.getRowstart() + bubble.getRow());
			wsheet.addCell(new Label(bubble.getColstart(),  bubble.getRowstart(), bubble.getContent(), headerFormat));
        }
        return wsheet;
	}

	public static WritableSheet excelOut(String name, int sheetNum, int rowCount,List<Bubble> categoryBubbleList, List<Bubble> titleBubbleList) throws Exception {
		WritableSheet wsheet = wts.createSheet(name, sheetNum);
		WritableCellFormat headerFormat = new WritableCellFormat();
		// 设置单元格边框
		headerFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		//默认是字体大小是10，现在改为11
        WritableFont font = new WritableFont(WritableFont.ARIAL,11);
        headerFormat.setFont(font);
        //水平居中对齐
        headerFormat.setAlignment(Alignment.CENTRE);
        //竖直方向居中对齐
        headerFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		 for (int i = 0; i < categoryBubbleList.size(); i++) {
	        	Bubble bubble = categoryBubbleList.get(i);
				wsheet.mergeCells(bubble.getColstart(), bubble.getRowstart()+rowCount, bubble.getColstart() + bubble.getCol(), bubble.getRowstart() + bubble.getRow()+rowCount);
				wsheet.addCell(new Label(bubble.getColstart(), bubble.getRowstart()+rowCount, bubble.getContent(), headerFormat));
	        }
	        for (int i = 0; i < titleBubbleList.size(); i++) {
	        	Bubble bubble = titleBubbleList.get(i);
	        	wsheet.mergeCells(bubble.getColstart(), bubble.getRowstart()+rowCount, bubble.getColstart() + bubble.getCol(), bubble.getRowstart() + bubble.getRow()+rowCount);
				wsheet.addCell(new Label(bubble.getColstart(), bubble.getRowstart()+rowCount, bubble.getContent(), headerFormat));
	        }
        return wsheet;
	}

}
