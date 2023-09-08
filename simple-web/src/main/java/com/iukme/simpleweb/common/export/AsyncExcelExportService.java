package com.iukme.simpleweb.common.export;

import com.alibaba.fastjson.JSONObject;
import com.iukme.simpleweb.common.utils.Result;
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
    private NewExportClient exportClient;

    @Override
    public Result<Integer> export(ExportModule module, ExportCondition dto) {

        AsyncExportDTO exportDTO = createExportDTO(module, dto);

        log.info("导出任务请求入参：{}", JSONObject.toJSONString(exportDTO));
        Result<Integer> result = exportClient.sendTask(exportDTO);

        return Result.success(result.result());
    }

    /**
     * 导出服务 查询
     * @param exportDTO
     * @return
     */
    @Override
    public Result selectTask(AsyncQueryExportDTO exportDTO) {
        JwtUserDTO user = LoginUserUtils.getJwtUser();
        exportDTO.setCreateBy(user.getId());
        exportDTO.setCreateByName(user.getName());
        return exportClient.selectTask(exportDTO);
    }


    public AsyncExportDTO createExportDTO(ExportModule module, ExportCondition dto) {

        ServletRequestAttributes attr = getServletRequestAttributes();

        if (attr == null) {
            throw new TmsServiceException(ResultCodeEnum.PARAMS_IS_INVALID.getCode(), "非法请求");
        }
        HttpServletRequest request = attr.getRequest();

        UpsUser user = LoginUserUtils.getUpsUser();

        AsyncExportDTO result = new AsyncExportDTO();

        result.setTimezone(TmsWebUtils.getTimezone());
        result.setLanguage(TmsWebUtils.getLanguage());
        result.setUser(user);
        result.setModulePath(module.getModulePath());
        result.setUrl(request.getRequestURI());
        result.setTaskName(module.getTaskName());
        result.setCondition(JSONUtil.toJsonStr(dto));
        result.setSheets(Arrays.asList(module.getSheet()));

        return result;
    }

    private static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }
}
