package com.yyf.bigplan.dao;

import com.yyf.bigplan.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author 杨宇飞 2019-11-19 6:33 下午
 * @version 1.0
 * @apiNote <p>记录地区数据调用</p>
 */
@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer>, JpaSpecificationExecutor<Place> {


}
