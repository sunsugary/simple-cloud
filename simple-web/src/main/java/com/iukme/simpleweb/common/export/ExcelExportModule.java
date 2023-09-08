package com.iukme.simpleweb.common.export;

/**
 * @author 
 * @date 2023/5/8 10:58
 */
public enum ExcelExportModule implements ExportModule {

    TEST_EXPORT("测试导出", "运力平台-测试功能", new String[]{"test1Service", "test2Service"}),
    ABNORMAL_PUNCH_CLOCK_EXPORT("异常打卡导出", "运力平台-异常打卡导出", new String[]{"testPunchClockAbnormalExportService"}),




    ;
    private final String[] sheets;

    private final String taskName;

    private final String modulePath;

    ExcelExportModule(String taskName, String modulePath, String[] services) {
        this.sheets = services;
        this.taskName = taskName;
        this.modulePath = modulePath;
    }

    @Override
    public String getModulePath() {
        return modulePath;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public String[] getSheet() {
        return sheets;
    }
}
