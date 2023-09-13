package com.iukme.simpleweb.common.export;

import com.iukme.simpleweb.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 新导入请求
 *
 * @author 
 * @date 2023/5/8 10:52
 */
@FeignClient(name = "tmsexportquery", path = "/tmsexportquery/async/export")
public interface ExportClient {

    /**
     * 异步导入出
     *
     * @param exportDTO 导出dto
     * @return 返回导出的条目
     */
    @PostMapping("/sendTask")
    Result<Integer> sendTask(@RequestBody AsyncExportDTO exportDTO);

    /**
     * 异步导入出 任务查询
     * @param exportDTO 导出dto
     * @return 返回导出的任务
     */
    @PostMapping("/selectTask")
    Result<AsyncExportTaskVO> selectTask(@RequestBody AsyncQueryExportDTO exportDTO);
}
