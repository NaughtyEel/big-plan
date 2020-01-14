package com.yyf.bigplan.controller;

import com.yyf.bigplan.controller.request.AddMoreUserRequest;
import com.yyf.bigplan.controller.request.AddOneUserRequest;
import com.yyf.bigplan.controller.request.FindPageUserRequest;
import com.yyf.bigplan.controller.request.ModifyUserRequest;
import com.yyf.bigplan.entity.User;
import com.yyf.bigplan.service.UserService;
import com.yyf.bigplan.vo.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 杨宇飞 2019-11-20 11:26 下午
 * @version 1.0
 * @apiNote <p>观察目标用户入口类</p>
 */
@Api(tags = "2-观察目标用户Api")
@Slf4j
@RestController("UserController")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取所有目标用户信息")
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @ApiOperation(value = "添加一个数据")
    @PostMapping("/one")
    @ResponseBody
    public BaseResponse addOne(@RequestBody @Valid AddOneUserRequest addOneUserRequest) {
        BaseResponse response = new BaseResponse();
        response.getEmptyOKRes();
        userService.addOne(addOneUserRequest);
        return response;
    }

    @ApiOperation(value = "一次性添加多个数据")
    @PostMapping("/more")
    @ResponseBody
    public BaseResponse addMore(@RequestBody @Valid AddMoreUserRequest addMoreUserRequest) {
        BaseResponse response = new BaseResponse();
        response.getEmptyOKRes();
        userService.addMore(addMoreUserRequest);
        return response;
    }

    @ApiOperation(value = "条件查询所有User 对象并分页")
    @PostMapping("/page")
    @ResponseBody
    public BaseResponse<Page<User>> page(@RequestBody @Valid FindPageUserRequest findPageUserRequest) {
        BaseResponse<Page<User>> response = new BaseResponse<>();
        try {
            response.getOKRes(userService.getPage(findPageUserRequest));
        } catch (Exception e) {
            log.error(e.getMessage());
            response.getErrorRes();
        }
        return response;
    }

    @ApiOperation(value = "修改user ，包括删除")
    @PostMapping("/modify")
    @ResponseBody
    public BaseResponse modify(@RequestBody @Valid ModifyUserRequest modifyUserRequest) {
        BaseResponse response = new BaseResponse();
        response.getEmptyOKRes();
        userService.modify(modifyUserRequest);
        return response;
    }

    @ApiOperation(value = "条件查询所有User 对象并分页")
    @GetMapping("/test")
    @ResponseBody
    public void test() {
        userService.test();
    }

}
