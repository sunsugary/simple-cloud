package com.iukme.simpleweb.common.export;

import com.iukme.simpleweb.common.dto.PageDTO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    private Long createBy;

    private String createByName;

}
