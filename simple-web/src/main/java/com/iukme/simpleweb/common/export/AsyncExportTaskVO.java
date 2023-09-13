package com.iukme.simpleweb.common.export;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class AsyncExportTaskVO {

    /**
     * 分布式ID
     */
    private Long id;

    /**
     * 导出任务名称
     */
    private String taskName;

    /**
     * 功能路径
     */
    private String modulePath;

    /**
     * 导出唯一请求路径，用于日志查询
     */
    private String url;

    /**
     * 导出的总数，导出结束后更新
     */
    private Integer count;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 导出状态，1进行中，2成功，3失败
     */
    private Integer state;

    /**
     * 异常详情
     */
    private String errorMsg;

    /**
     * 创建者
     */
    private Integer createBy;

    /**
     * 创建者名称
     */
    private String createByName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 消耗时间，单位秒
     */
    private Integer useTime;

    /**
     * oss地址
     */
    private String ossUrl;

    /**
     * 语言
     */
    private String language;

    /**
     * 时区
     */
    private String timezone;

}
