package com.solo.web.controller;

import com.solo.common.model.ResultModel;
import com.solo.common.verify.Verification;
import com.solo.web.service.ExcelService;
import io.swagger.annotations.ApiOperation;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: GaoJean
 * @ClassName: ExcelController
 * @Description: TODO
 * @date: 2018/7/29
 */
@RestController
@RequestMapping("/excel")
public class ExcelController extends BaseController{

    @Autowired
    private ExcelService excelService;

    @GetMapping("/createExcel")
    @ApiOperation(value = "createExcel", notes = "生成Excel")
    @Verification(token = false)
    public ResultModel createExcel( HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> params = new HashMap<>();
        logger.info("params = {}", params);
        return success(excelService.createExcel(request, response, params));
    }


}
