package com.iukme.simpleweb.feign;

import com.iukme.common.export.AsyncExportDTO;
import com.iukme.common.export.AsyncQueryExportDTO;
import com.iukme.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "simple-export", path = "/common/export")
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
    Result selectTask(@RequestBody AsyncQueryExportDTO exportDTO);
}