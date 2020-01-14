package com.yyf.bigplan.remote.hystrix;

import com.yyf.bigplan.dto.PlaceDTO;
import com.yyf.bigplan.remote.PlaceRemoteService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 杨宇飞 2020-01-13 4:33 下午
 * @version 1.0
 * @apiNote <p>熔断，降级策略</p>
 */
@Component
public class PlaceRemoteHystrix implements PlaceRemoteService {

    @Override
    public List<PlaceDTO> getAll() {
        return null;
    }

}
