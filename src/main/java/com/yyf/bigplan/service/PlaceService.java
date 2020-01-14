package com.yyf.bigplan.service;

import com.yyf.bigplan.controller.request.AddAndModifyPlaceRequest;
import com.yyf.bigplan.controller.request.DelOnePlaceRequest;
import com.yyf.bigplan.controller.request.ModifyPlaceRequest;
import com.yyf.bigplan.controller.response.StatisticalResponse;
import com.yyf.bigplan.dto.PlaceDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杨宇飞 2019-11-19 6:42 下午
 * @version 1.0
 * @apiNote <p>记录地区服务接口</p>
 */
@Service
public interface PlaceService {

    /**
     * 获取所有记录地区
     *
     * @return 所有记录地区
     */
    public List<PlaceDTO> getAll();

    /**
     * 新增一个新的记录地点
     *
     * @param addAndModifyPlaceRequest 地点信息
     */
    public void addOne(AddAndModifyPlaceRequest addAndModifyPlaceRequest);

    /**
     * 修改一个新的记录地点
     *
     * @param addAndModifyPlaceRequest 地点信息
     */
    public void modify(AddAndModifyPlaceRequest addAndModifyPlaceRequest);

    /**
     * 删除一个的记录地点
     *
     * @param delOnePlaceRequest {@link DelOnePlaceRequest}
     */
    public void delOne(DelOnePlaceRequest delOnePlaceRequest);

    /**
     * 获取指定地点的统计结果
     *
     * @param placeId 地点id
     */
    public StatisticalResponse statistical(String placeId);

    /**
     * 上传图片
     *
     * @param modifyPlaceRequest {@link ModifyPlaceRequest}
     */
    public void uploadImg(ModifyPlaceRequest modifyPlaceRequest);

}
