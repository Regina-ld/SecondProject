package com.regina.pro.controller;

import com.regina.pro.base.BaseController;
import com.regina.pro.base.ResultData;
import com.regina.pro.domain.ProductCate;
import com.regina.pro.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Regina
 * @data 2019/11/23 11:47
 * @project repast-pro-parent
 * @declaration:
 *    商品种类controller
 */
@RestController
@Api(value = "商品类型",tags = "商品类型接口")
public class CategoryController extends BaseController {

    @Autowired
    private IRepastService iRepastService;

    /**
     * 通过层级查询商品类型
     * @param level
     * @return
     */
    @GetMapping("/getByLevel")
    @ApiOperation(value = "商品类型",notes = "通过层级查询商品类型")
    public ResultData getCateByLevel(Integer level){
        List<ProductCate> ProductCate = iRepastService.getCateByLevel(level);
        if (null != ProductCate){
            return success(ProductCate);
        }else {
            return failed();
        }
    }
}
