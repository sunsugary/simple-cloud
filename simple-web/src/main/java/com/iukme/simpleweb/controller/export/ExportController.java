package com.iukme.simpleweb.controller.export;

import com.alibaba.fastjson.JSON;
import com.iukme.common.export.AsyncExportTaskVO;
import com.iukme.common.export.AsyncQueryExportDTO;
import com.iukme.common.export.ExcelExportModule;
import com.iukme.common.export.TestExportDTO;
import com.iukme.common.utils.Result;
import com.iukme.simpleweb.service.ExcelExportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 新导入重构
 *
 * @author 
 * @date 2023/5/8 10:51
 */
@Slf4j
@RequestMapping("/export")
@RestController
public class ExportController {

    @Resource
    private ExcelExportService excelExportService;

    @PostMapping("/doExport")
    public Result<Integer> doExport(@RequestBody TestExportDTO dto) {
        return excelExportService.export(ExcelExportModule.TEST_EXPORT, dto);
    }


    @PostMapping("/selectTask")
    public Result<AsyncExportTaskVO> selectTask(@RequestBody AsyncQueryExportDTO exportDTO) {
        log.info("导出任务查询：{}", JSON.toJSONString(exportDTO));
        return excelExportService.selectTask(exportDTO);
    }

}
