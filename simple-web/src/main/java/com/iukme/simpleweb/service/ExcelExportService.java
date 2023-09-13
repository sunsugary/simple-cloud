package com.iukme.simpleweb.service;


import com.iukme.common.export.AsyncExportTaskVO;
import com.iukme.common.export.AsyncQueryExportDTO;
import com.iukme.common.export.ExportCondition;
import com.iukme.common.export.ExportModule;
import com.iukme.common.utils.Result;

/**
 * excel导出服务
 *
 * @author 
 * @date 2023/5/8 11:16
 */
public interface ExcelExportService {

    /**
     * 执行导出服务
     *
     * @param module 导出model
     */
    Result<Integer> export(ExportModule module, ExportCondition dto);

    /**
     * 导出服务 查询
     * @param exportDTO
     * @return
     */
    Result<AsyncExportTaskVO> selectTask(AsyncQueryExportDTO exportDTO);
}
