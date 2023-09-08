package com.iukme.simpleweb.common.export;

import java.io.Serializable;

/**
 * 导出dto
 *
 * @author 
 * @date 2023/5/8 11:19
 */
public interface ExportCondition extends Serializable {

    /**
     * 前端缓存的count数，如果大于0，导出任务不会校验是否还存在数据
     *
     * @return 前端缓存的count数
     */
    default Integer getCount() {
        return 0;
    }
}
