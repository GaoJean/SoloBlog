package com.solo.common.util.excel;

import com.solo.common.util.excel.impl.Bubble;
import com.solo.common.util.excel.impl.ExcelCommon;
import com.solo.common.util.excel.impl.ExcelContent;
import jxl.write.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author: GaoJean
 * @ClassName: ExcelUtil
 * @Description: TODO
 * @date: 2018/7/29
 */
public class ExcelUtil {

    private final static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    private static final int EXCEL_SHEETSIZE = 50000;


    public static void createExcel(HttpServletResponse response, String fileName, ExcelContent context) throws Exception {
        List<String> titleList = context.getTitle();
        List<List<Bubble>> complexTitle = context.getComplexTitle();
        List<String> headers = context.getHeaders();
        List<String> footers = context.getFooters();
        List<List<List<Bubble>>> complexContent = context.getComplexContent();
        Integer sheetCount = context.getOffset();
        Integer contentSize = context.getContentSize();
        List<List<String>> contentList = context.getContent();
        //报表中订单总数量总金额
        Map<String, String> totalMap = context.getTotalNumAndPrice();
        Map<Integer, String> footerMap = context.getFooterMap();
        if (titleList == null || (titleList.size() == 0 && complexTitle.size() == 0) || contentList == null
                ) {
            logger.info("createExcelFile process exit");
            return;
        }

        try {

            WritableSheet wsheet = null;
            //this.setResponseHeader(response,fileName);
            setResponseHeader(response, fileName);
            ExcelCommon.getWritableWorkbook(response.getOutputStream());
            int cellCount = titleList.size() == 0 ? complexTitle.get(1).size() : titleList.size(); //单元格数
            int length = contentList.size() == 0 ? contentSize : contentList.size(); //数据条数
            int sheetSize = (sheetCount == null ? EXCEL_SHEETSIZE : sheetCount.intValue());
            if (sheetSize == 0) {
                sheetSize = EXCEL_SHEETSIZE;
            }
            int sheetNum = 0; //sheet页数
            if (length % sheetSize > 0) {
                sheetNum = length / sheetSize + 1;
            } else {
                sheetNum = length / sheetSize;
            }
            if (sheetNum == 0) {
                sheetNum = 1;
            }
            int tempRowCount = 0; //行号指示器
            int headerNum = 0; //表头行数
            WritableCellFormat cellFormat = new WritableCellFormat();
            //默认是字体大小是10，改为11
            WritableFont font = new WritableFont(WritableFont.ARIAL, 11);
            //设置字体;
            //设置单元格边框
            cellFormat.setFont(font);
            cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
            cellFormat.setAlignment(Alignment.CENTRE);
            cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
            //遍历记录到excel
            for (int m = 0; m < sheetNum; m++) {
                if (headers == null || headers.size() == 0) {
                    if (titleList.size() != 0) {
                        wsheet = ExcelCommon.excelOut("sheet" + m, m, titleList); //表格标题
                    } else {
                        wsheet = ExcelCommon.excelOut("sheet" + m, m, complexTitle.get(0), complexTitle.get(1)); //表格标题
                    }
                } else {
                    headerNum = headers.size();
                    if (titleList.size() != 0) {
                        wsheet = ExcelCommon.excelOut("sheet" + m, m, headerNum, titleList); //表格标题
                    } else {
                        wsheet = ExcelCommon.excelOut("sheet" + m, m, headerNum, complexTitle.get(0), complexTitle.get(1)); //表格标题
                    }
                    for (int h = 0; h < headerNum; h++) { //表头部分
                        wsheet.mergeCells(0, h, cellCount - 1, h);
                        WritableCell cell = new Label(0, h, headers.get(h), cellFormat);
                        wsheet.addCell(cell);
                    }
                }
                tempRowCount = headerNum + (complexTitle.size() == 0 ? 0 : complexTitle.size() - 1);
                //数据写入表格
                if (contentList.size() > 0) {
                    for (int i = m * sheetSize; i < (m + 1) * sheetSize && i < length; i++) {
                        tempRowCount++;
                        List<String> tmpList = contentList.get(i);
                        if (tmpList.size() > 0) {
                            for (int j = 0; j < cellCount; j++) {
                                wsheet.addCell(new Label(j, tempRowCount, tmpList.get(j), cellFormat));
                                //设置行高16.5
                                wsheet.setRowView(tempRowCount + 1, 330);
                                //设置列宽 15
                                wsheet.setColumnView(j, 15);
                            }
                        }
                    }
                }
                //多少列
                if (complexContent.size() > 0) {
                    for (List<List<Bubble>> bubbleRowList : complexContent) {
                        tempRowCount++;
                        int useRow = 0;
                        if (bubbleRowList.size() > 0) {
                            Iterator<List<Bubble>> bulleRowIterator = bubbleRowList.iterator();//一列
                            int beginCol = 0;
                            while (bulleRowIterator.hasNext()) {
                                int beginRow = tempRowCount;
                                List<Bubble> bubbleList = bulleRowIterator.next();    //一组
                                Iterator<Bubble> bubbleIterator = bubbleList.iterator();
                                while (bubbleIterator.hasNext()) {
                                    Bubble bubble = bubbleIterator.next();
                                    if (bubble.getRow() > 1) {
                                        wsheet.mergeCells(beginCol, beginRow, beginCol, beginRow + bubble.getRow() - 1);
                                    }
                                    wsheet.addCell(new Label(beginCol, beginRow, bubble.getContent(), cellFormat));
                                    //设置行高16.5
                                    wsheet.setRowView(beginRow, 330);
                                    //设置列宽 15
                                    wsheet.setColumnView(beginCol, 15);
                                    beginRow += bubble.getRow();
                                    if (bubble.getRow() > useRow) {
                                        useRow += bubble.getRow();
                                    }
                                    bubbleIterator.remove();
                                }
                                beginCol++;

                                bulleRowIterator.remove();
                            }
                        }
                        if (useRow > 1) {
                            tempRowCount += useRow - 1;
                        }
                    }
                }
                //表格尾部
                if (m == sheetNum - 1) { //最后一页
                    //总数量，总金额
                    if (totalMap != null && totalMap.size() > 0) {
                        String totalNumColStr = totalMap.get("totalNumCol");
                        String totalPriceColStr = totalMap.get("totalPriceCol");
                        if (StringUtils.isNotBlank(totalNumColStr) || StringUtils.isNotBlank(totalPriceColStr)) {
                            Integer totalNumCol = totalNumColStr != null ? Integer.valueOf(totalNumColStr) : null;
                            Integer totalPriceCol = totalPriceColStr != null ? Integer.valueOf(totalPriceColStr) : null;
                            wsheet.addCell(new Label(0, ++tempRowCount, "总计", cellFormat));
                            for (int i = 1; i < cellCount - 1; i++) {
                                if ((totalNumCol != null && i != totalNumCol) || (totalPriceCol != null && i != totalPriceCol)) {
                                    wsheet.addCell(new Label(i, tempRowCount, "", cellFormat));
                                    wsheet.setRowView(tempRowCount, 330);
                                    wsheet.setColumnView(i, 15);
                                }
                            }
                            if (totalMap.get("totalNum") != null && totalMap.get("totalNumCol") != null) {
                                wsheet.addCell(new Label(totalNumCol, tempRowCount, totalMap.get("totalNum"), cellFormat));
                            }
                            if (totalMap.get("totalPrice") != null && totalMap.get("totalPriceCol") != null) {
                                wsheet.addCell(new Label(totalPriceCol, tempRowCount, totalMap.get("totalPrice"), cellFormat));
                            }
                        }
                    }

                    if (footerMap != null && footerMap.size() > 0) {
                        tempRowCount++;
                        wsheet.addCell(new Label(0, tempRowCount, "总计", cellFormat));
                        //先格式化最后一行，均设置为空字符串
                        for (int i = 1; i < cellCount - 1; i++) {
                            wsheet.addCell(new Label(i, tempRowCount, "", cellFormat));
                        }
                        //向最后一行，添加单元格数据
                        for (Integer key : footerMap.keySet()) {
                            wsheet.addCell(new Label(key, tempRowCount, footerMap.get(key), cellFormat));
                        }
                    }
                    if (footers != null && footers.size() > 0) {
                        for (int k = 0; k < footers.size(); k++) {
                            wsheet.mergeCells(0, tempRowCount + 1 + k, cellCount - 1, tempRowCount + 1 + k);
                            wsheet.addCell(new Label(0, tempRowCount + 1 + k, footers.get(k), cellFormat));
                        }
                    }
                }
            }
            ExcelCommon.getWritableWorkbook().write();
            ExcelCommon.getWritableWorkbook().close();

           /* OutputStream outputStream = response.getOutputStream();// 打开流
            wb.write(outputStream);// HSSFWorkbook写入流
            wb.close();// HSSFWorkbook关闭
            outputStream.flush();// 刷新流
            outputStream.close();// 关闭流*/
        } catch (Exception e) {
            logger.error("createExcelFile", e);
            throw e;
        } finally {
            try {
                if (response.getOutputStream() != null) {
                    response.getOutputStream().close();
                }
                logger.info("response.getOutputStream() finished!");
            } catch (Exception ex) {
                logger.error("response.getOutputStream()", ex);
            }
        }

    }

    //发送响应流方法
    private static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = URLEncoder.encode(fileName, "UTF-8");
                //fileName = new String(fileName.getBytes(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                logger.info("e:{}", e.getMessage());
                e.printStackTrace();
            }
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            logger.info("ex:{}", ex.getMessage());
            ex.printStackTrace();
        }
    }
}
