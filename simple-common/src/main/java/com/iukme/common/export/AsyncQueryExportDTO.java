package com.iukme.common.export;

import com.iukme.common.dto.PageDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 
 * @date 2023/5/8 11:19
 */
@Data
public class AsyncQueryExportDTO extends PageDTO {

    /**
     * 导出地址
     */
    private List<String> exportUrls;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Long createBy;

    private String createByName;

}
