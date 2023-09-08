package com.iukme.simpleweb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "simple-query")
public interface UserFeign {

    @GetMapping("/user/page") // 指定远程服务的端点路径
    String page(@RequestParam(value = "name") String name);
}
