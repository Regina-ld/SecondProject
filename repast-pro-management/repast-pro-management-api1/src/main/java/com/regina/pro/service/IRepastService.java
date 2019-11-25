package com.regina.pro.service;

import com.regina.pro.domain.Member;
import com.regina.pro.domain.ProductCate;
import com.regina.pro.fallback.RepastFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Regina
 * @data 2019/11/22 0:55
 * @project repast-pro-parent
 * @declaration:
 *         fallbackFactory表示开启熔断
 *         一旦开启熔断，也会从eureka中发现服务，但是直接会通过provider项目的spring.application.name的值调用服务
 *         此处的value值一定要小写！但是就算是大写也不会报错，因为最终feign会全部转化为小写
 */
@FeignClient(value = "product-interface-provider" , fallbackFactory = RepastFallBackFactory.class)
public interface IRepastService {

    /**
     * 执行登录操作
     * @param member
     * @return
     */
    @PostMapping("/login")
    Boolean doLogin(@RequestBody Member member);

    /**
     * 通过层级查询商品类型
     * @param level
     * @return
     */
    @GetMapping("/getByLevel")
    List<ProductCate> getCateByLevel(@RequestParam("level") Integer level);

}
