package com.iukme.simpleweb.common.export;

import com.alibaba.fastjson.JSONObject;
import com.iukme.simpleweb.common.ResultCodeEnum;
import com.iukme.simpleweb.common.exception.TmsServiceException;
import com.iukme.simpleweb.common.utils.LoginUtil;
import com.iukme.simpleweb.common.utils.Result;
import com.iukme.simpleweb.common.vo.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 异步导出服务
 *
 * @author 
 * @date 2023/5/8 11:18
 */
@Component
@Slf4j
public class AsyncExcelExportService implements ExcelExportService {

    @Resource
    private ExportClient exportClient;

    @Override
    public Result<Integer> export(ExportModule module, ExportCondition dto) {

        AsyncExportDTO exportDTO = createExportDTO(module, dto);

        log.info("导出任务请求入参：{}", JSONObject.toJSONString(exportDTO));

        return exportClient.sendTask(exportDTO);
    }

    /**
     * 导出服务 查询
     * @param exportDTO
     * @return
     */
    @Override
    public Result<AsyncExportTaskVO> selectTask(AsyncQueryExportDTO exportDTO) {
        LoginUser loginUser = LoginUtil.loginUser();
        exportDTO.setCreateBy(loginUser.getUserId());
        exportDTO.setCreateByName(loginUser.getUserName());
        return exportClient.selectTask(exportDTO);
    }


    public AsyncExportDTO createExportDTO(ExportModule module, ExportCondition dto) {

        ServletRequestAttributes attr = getServletRequestAttributes();

        if (attr == null) {
            throw new TmsServiceException(ResultCodeEnum.PARAMS_IS_INVALID.getCode(), "非法请求");
        }
        HttpServletRequest request = attr.getRequest();

        LoginUser loginUser = LoginUtil.loginUser();

        AsyncExportDTO result = new AsyncExportDTO();

        result.setTimezone("");
        result.setLanguage("");
        result.setUser(loginUser);
        result.setModulePath(module.getModulePath());
        result.setUrl(request.getRequestURI());
        result.setTaskName(module.getTaskName());
        result.setCondition(JSONObject.toJSONString(dto));
        result.setSheets(Arrays.asList(module.getSheet()));

        return result;
    }

    private static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }
}
