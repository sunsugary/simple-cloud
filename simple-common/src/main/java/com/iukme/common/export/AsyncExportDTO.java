package com.iukme.common.export;

import com.iukme.common.vo.LoginUser;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 异步导出dto
 *
 * @author 
 * @date 2023/5/10 11:08
 */
@Data
public class AsyncExportDTO implements Serializable {

    /**
     * 功能请求地址，用于判定请求的唯一标识，此处解决使用int类型编码难以维护或可能出现冲突的问题，此属性实际是由后端提供并与前端约定
     * 示例：/transportation/branchOnTime/export
     */
    private String url;

    /**
     * 功能路径
     */
    private String modulePath;

    /**
     * 语言
     */
    private String language;

    /**
     * 时区
     */
    private String timezone;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * sheet
     */
    private List<String> sheets;

    /**
     * 处理条件，可以是一个json
     */
    private String condition;

    /**
     * 操作的用户
     */
    private LoginUser user;
}
