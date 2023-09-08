package com.iukme.simpleweb.common.export;

/**
 * 导出策略
 *
 * @author 
 * @date 2023/5/8 10:56
 */
public interface ExportModule {

    /**
     * 功能路径
     *
     * @return 功能的全路径
     */
    String getModulePath();

    /**
     * 任务名称
     *
     * @return 任务名称
     */
    String getTaskName();

    /**
     * 多个导出，最终导出sheet以数组顺序为准
     *
     * @return sheets
     */
    String[] getSheet();

}
