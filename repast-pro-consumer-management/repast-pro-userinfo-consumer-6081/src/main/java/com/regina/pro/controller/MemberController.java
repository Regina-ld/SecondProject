package com.regina.pro.controller;

import com.regina.pro.base.BaseController;
import com.regina.pro.base.ResultData;
import com.regina.pro.domain.Member;
import com.regina.pro.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Regina
 * @data 2019/11/22 11:23
 * @project repast-pro-parent
 * @declaration:
 */
@RestController
@Api(value = "用户信息",tags = "用户信息接口")
public class MemberController extends BaseController {

    @Autowired
    private IRepastService iRepastService;

    @PostMapping("/login")
    @ApiOperation(value = "登录",notes = "执行登陆操作")
    public ResultData doLogin(Member member) {
        if (iRepastService.doLogin(member)) {
            return success();
        } else {
            return failed();
        }
    }
}
