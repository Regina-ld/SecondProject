package com.regina.pro.service;

import com.regina.pro.base.BaseService;
import com.regina.pro.domain.Member;
import com.regina.pro.mapper.MemberMapper;
import com.regina.pro.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import static com.regina.pro.staticstatus.StaticProperties.*;

/**
 * @author Regina
 * @data 2019/11/22 21:24
 * @project repast-pro-parent
 * @declaration:
 */
@Service
public class MemberService extends BaseService<Member> {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Mapper<Member> getMapper() {
        return memberMapper;
    }

    /**
     * 执行登陆操作
     * @param member
     * @param redisService
     * @return
     */
    public Boolean doLogin(Member member,RedisService redisService){
        try {
            Member mbr = super.selectOne(member);
            if(null != mbr){
                mbr.setPassword(null);
                String mbrString = JSONUtil.toJsonString(mbr);
                String setResult = redisService.set(REDIS_KEY, mbrString);
                if (OK.equals(setResult.toUpperCase())){
                    //说明存入redis成功
                    return true;
                }
                //说明登录成功
                //此时应该把用户对象存入session中
                /**
                 * ！！！面试题！！！
                 * Q1:如果涉及到session跨域问题面试题：
                 *     1.如果是Ajax，那么session跨域传递数据必须使用jsonp
                 *     2.如果是常规的的调用：
                 *         解决方式一：把user对象存到redis中，也就是说redis相当于session，然后把redis的key存入到cookie中
                 * //TODO  解决方式二：查找！！！session的全局配置---关键的配置：允许所有人继续访问
                 * Q2:什么是脏读什么是幻读？
                 * 两者没有太大的差别，两者唯一的区别就看事务是否提交（即是否执行了commit操作）
                 * 如果执行了，则就是幻读；如果没有执行，则就是脏读。
                 */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
