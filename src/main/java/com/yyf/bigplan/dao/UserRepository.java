package com.yyf.bigplan.dao;

import com.yyf.bigplan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 杨宇飞 2019-11-20 11:40 下午
 * @version 1.0
 * @apiNote <p>观察目标用户数据调用</p>
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {


}
