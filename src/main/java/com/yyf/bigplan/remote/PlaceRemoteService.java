package com.yyf.bigplan.remote;

import com.yyf.bigplan.dto.PlaceDTO;
import com.yyf.bigplan.remote.hystrix.PlaceRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author 杨宇飞 2020-01-13 4:29 下午
 * @version 1.0
 * @apiNote <p>服务提供者</p>
 */
@FeignClient(name = "big-plan-provide", fallback = PlaceRemoteHystrix.class)
public interface PlaceRemoteService {

    @GetMapping("/all")
    public List<PlaceDTO> getAll();

}
