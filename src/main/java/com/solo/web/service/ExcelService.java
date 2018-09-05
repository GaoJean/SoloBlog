package com.solo.web.service;

import com.solo.common.util.excel.ExcelUtil;
import com.solo.common.util.excel.impl.ExcelContent;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: GaoJean
 * @ClassName: ExcelService
 * @Description: TODO
 * @date: 2018/7/29
 */
@Service
public class ExcelService {

    private final static Logger logger = LoggerFactory.getLogger(ExcelService.class);

    public boolean createExcel(HttpServletRequest request, HttpServletResponse response, Map<String, Object> params) throws Exception {
        ExcelContent excelContent = new ExcelContent();
        this.addHeaders(excelContent);
        this.addTitle(excelContent);
        List<List<String>> content = new ArrayList<>();
        String fileName = "test.xls";
        //1.查询数据，组装data
        for (int i = 0; i < 10; i++) {
            List<String> data = new ArrayList<>();
            data.add(String.valueOf(i));
            data.add(String.valueOf(i + 10));
            data.add(String.valueOf(i + 20));
            content.add(data);
        }
        //2.调用Excel工具，填充数据
        excelContent.setContent(content);
        //结尾
        Map<Integer, String> footerMap = new HashMap<Integer, String>();
        footerMap.put(0, "总计");
        footerMap.put(2, "22222");
        excelContent.setFooterMap(footerMap);
        ExcelUtil.createExcel(response,fileName, excelContent);

        /*WritableWorkbook book = Workbook.createWorkbook(response.getOutputStream());
        WritableSheet sheet = book.createSheet("1",0);
        Label label =new Label(0, 0, " test ");
        sheet.addCell(label);

        jxl.write.Number number = new jxl.write.Number(1, 0, 555.12541);
        sheet.addCell(number);
        book.write();
        book.close();*/
        //3.返回结果
        return true;
    }

    public String getDescription() {
        return "ExcelService";
    }

    // 构造文件头部信息
    private void addHeaders(ExcelContent content) {
        logger.info("开始构造 " + this.getDescription() + " excel文件表头.");
        List<String> headers = new ArrayList<String>();
        headers.add("ExcelService");
        headers.add("订单列表");
        content.setHeaders(headers);
        logger.info("构造 " + this.getDescription() + " excel文件表头完成.");
    }

    //构造文件标题信息
    private void addTitle(ExcelContent content) {
        logger.info("开始构造 " + this.getDescription() + " excel文件标题.");
        List<String> title = new ArrayList<String>();
        title.add("序号");
        title.add("数据");
        title.add("总计");

        content.setTitle(title);
        logger.info("构造 " + this.getDescription() + " excel文件标题完成.");
    }

}
