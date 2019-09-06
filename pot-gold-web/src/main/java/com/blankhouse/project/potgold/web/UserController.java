package com.blankhouse.project.potgold.web;

import com.blankhouse.project.potgold.config.BaseResult;
import com.blankhouse.project.potgold.mapper.UserMapper;
import com.blankhouse.project.potgold.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(value = "用户管理", description = "用户管理API", position = 100, protocols = "http")
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "所有用户", notes = "")
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public BaseResult<List<User>> getUsers() {
        List<User> users = userMapper.getAll();
        return BaseResult.successWithData(users);
    }

    @ApiOperation(value = "id获取用户", notes = "")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public BaseResult<User> getUser(Long id) {
        User user = userMapper.getOne(id);
        return BaseResult.successWithData(user);
    }

    @ApiOperation(value = "增加用户", notes = "")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult save(User user) {
        userMapper.insert(user);
        return BaseResult.success();
    }

    @ApiOperation(value = "更新用户信息", notes = "")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public BaseResult update(User user) {
        userMapper.update(user);
        return BaseResult.success();
    }

    @ApiOperation(value = "删除用户", notes = "")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public BaseResult delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
        return BaseResult.success();
    }


}