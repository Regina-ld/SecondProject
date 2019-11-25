package com.regina.pro.fallback;

import com.regina.pro.domain.Member;
import com.regina.pro.domain.ProductCate;
import com.regina.pro.service.IRepastService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Regina
 * @data 2019/11/22 0:57
 * @project repast-pro-parent
 * @declaration:
 */
@Component
public class RepastFallBackFactory implements FallbackFactory<IRepastService> {

    @Override
    public IRepastService create(Throwable throwable) {
        IRepastService repastService=new IRepastService() {

            @Override
            public Boolean doLogin(Member member) {
                System.out.println("测试登录熔断数据");
                return null;
            }

            @Override
            public List<ProductCate> getCateByLevel(Integer level) {
                System.out.println("测试商品类型熔断数据");
                return null;
            }
        };
        return repastService;
    }
}
