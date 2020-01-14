package com.yyf.bigplan.controller;

import com.yyf.bigplan.controller.request.AddAndModifyPlaceRequest;
import com.yyf.bigplan.controller.request.DelOnePlaceRequest;
import com.yyf.bigplan.controller.request.ModifyPlaceRequest;
import com.yyf.bigplan.controller.response.StatisticalResponse;
import com.yyf.bigplan.dto.PlaceDTO;
import com.yyf.bigplan.service.PlaceService;
import com.yyf.bigplan.util.Base64Utils;
import com.yyf.bigplan.vo.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * @author 杨宇飞 2019-11-19 6:36 下午
 * @version 1.0
 * @apiNote <p>地区入口类</p>
 */
@Api(tags = "1-地区Api")
@Slf4j
@RestController("PlaceController")
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @ApiOperation(value = "获取所有地区信息")
    @GetMapping("/all")
    public BaseResponse<List<PlaceDTO>> getAll() {
        BaseResponse<List<PlaceDTO>> response = new BaseResponse<>();
        try {
            response.getOKRes(placeService.getAll());
        } catch (Exception e) {
            log.error(e.getMessage());
            response.getErrorRes();
        }
        return response;
    }

    @ApiOperation(value = "添加地区信息")
    @PutMapping
    public BaseResponse addOne(@RequestBody @Valid AddAndModifyPlaceRequest addAndModifyPlaceRequest) {
        BaseResponse response = new BaseResponse();
        try {
            placeService.addOne(addAndModifyPlaceRequest);
            response.getEmptyOKRes();
        } catch (Exception e) {
            log.error(e.getMessage());
            response.getErrorRes();
        }
        return response;
    }

    @ApiOperation(value = "修改地区信息")
    @PostMapping("/modify")
    public BaseResponse modifyOne(@RequestBody @Valid AddAndModifyPlaceRequest addAndModifyPlaceRequest) {
        BaseResponse response = new BaseResponse();
        try {
            placeService.modify(addAndModifyPlaceRequest);
            response.getEmptyOKRes();
        } catch (Exception e) {
            log.error(e.getMessage());
            response.getErrorRes();
        }
        return response;
    }

    @ApiOperation(value = "删除地区信息")
    @DeleteMapping
    @ResponseBody
    public BaseResponse delOne(@RequestBody @Valid DelOnePlaceRequest delOnePlaceRequest) {
        BaseResponse response = new BaseResponse();
        try {
            placeService.delOne(delOnePlaceRequest);
            response.getEmptyOKRes();
        } catch (Exception e) {
            log.error(e.getMessage());
            response.getErrorRes();
        }
        return response;
    }

    @ApiOperation(value = "获取对应placeId 的统计信息")
    @GetMapping("/statistical")
    public BaseResponse<StatisticalResponse> getAll(@RequestParam(name = "placeId") Integer placeId) {
        BaseResponse<StatisticalResponse> response = new BaseResponse<>();
        try {
            response.getOKRes(placeService.statistical(placeId.toString()));
        } catch (Exception e) {
            log.error(e.getMessage());
            response.getErrorRes();
        }
        return response;
    }

    // 处理图片上传
    @ApiOperation(value = "修改user ，包括删除")
    @PostMapping("/uploadImg")
    @ResponseBody
    public BaseResponse uploadImg(@RequestBody ModifyPlaceRequest modifyPlaceRequest) {
        BaseResponse response = new BaseResponse();
        try {
            try {
                placeService.uploadImg(modifyPlaceRequest);
                response.getEmptyOKRes();
            } catch (Exception e) {
                log.error(e.getMessage());
                response.setMsg(e.getMessage());
                response.getErrorRes();
            }
            return response;
        } catch (Exception e) {
            log.error(e.getMessage());
            response.getErrorRes();
        }
        return response;
    }

    // 获取图片
    @ApiOperation(value = "修改user ，包括删除")
    @GetMapping(value = "/img")
    public void getImg(@RequestParam String imgUrl, HttpServletResponse response) {
        try {
            if (StringUtils.isEmpty(imgUrl) || "null".equals(imgUrl)) {
                imgUrl = "/home/yangyufei/bigPlan/image/puzzled.jpeg";
            }
            response.setContentType("image/jpeg");  //设置显示图片
            response.setHeader("Cache-Control", "max-age=604800"); //设置缓存
            Base64Utils.downloadFile(imgUrl, response.getOutputStream());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
