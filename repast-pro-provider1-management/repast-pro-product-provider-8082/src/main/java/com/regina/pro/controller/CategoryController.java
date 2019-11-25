package com.regina.pro.controller;

import com.regina.pro.domain.ProductCate;
import com.regina.pro.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Regina
 * @data 2019/11/23 16:51
 * @project repast-pro-parent
 * @declaration:
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    /**
     * 通过层级查询商品类型
     * @param level
     * @return
     */
    @GetMapping("/getByLevel")
    public List<ProductCate> getCateByLevel(@RequestParam("level") Integer level){
        return categoryService.getCateByLevel(level);
    };
}
