package com.solo.web.controller;

import com.solo.common.model.ResultModel;
import com.solo.common.verify.Verification;
import com.solo.web.service.ExcelService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author: GaoJean
 * @ClassName: ExcelController
 * @Description: TODO
 * @date: 2018/7/29
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {
    private final static Logger logger = LoggerFactory.getLogger(ExcelController.class);

    @Autowired
    private ExcelService excelService;

    @PostMapping("/createExcel")
    @ApiOperation(value = "createExcel", notes = "生成Excel")
    @Verification(token = false)
    public ResultModel createExcel(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("params = {}", params);
        ResultModel resultModel = new ResultModel();
        resultModel.setModel(excelService.createExcel(request,response,params));
        return resultModel;
    }
}
