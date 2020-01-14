package com.yyf.bigplan.service;


import com.yyf.bigplan.controller.request.AddMoreUserRequest;
import com.yyf.bigplan.controller.request.AddOneUserRequest;
import com.yyf.bigplan.controller.request.FindPageUserRequest;
import com.yyf.bigplan.controller.request.ModifyUserRequest;
import com.yyf.bigplan.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杨宇飞 2019-11-20 11:42 下午
 * @version 1.0
 * @apiNote <p>观察目标用户服务接口</p>
 */
@Service
public interface UserService {

    /**
     * 获取所有观察目标用户
     * @return 所有观察目标用户
     */
    public List<User> getAll();

    /**
     * 条件查询所有User 对象并分页
     * @param findPageUserRequest 条件查询对象
     * @return 分页集合
     */
    public Page<User> getPage(FindPageUserRequest findPageUserRequest);

    /**
     * 添加一个用户数据
     */
    public void addOne(AddOneUserRequest addOneUserRequest);

    /**
     * 添加多个用户数据
     */
    public void addMore(AddMoreUserRequest addMoreUserRequest);

    /**
     * 修改user ，包括删除
     */
    public void modify(ModifyUserRequest modifyUserRequest);

    public void test();

}
