package com.iukme.simpleweb.common.export;


import com.iukme.simpleweb.common.utils.Result;

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
