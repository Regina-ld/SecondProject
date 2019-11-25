package com.regina.pro.controller;

import com.regina.pro.domain.Member;
import com.regina.pro.service.MemberService;
import com.regina.pro.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Regina
 * @data 2019/11/22 21:19
 * @project repast-pro-parent
 * @declaration:
 */
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private RedisService redisService;
    /**
     * 执行登录操作
     * @param member
     * @return
     */
    @PostMapping("/login")
    public Boolean doLogin(@RequestBody Member member)  {
        return memberService.doLogin(member,redisService);
    }

}
