package com.regina.pro.service;

import com.regina.pro.domain.ProductCate;
import com.regina.pro.mapper.ProductCateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Regina
 * @data 2019/11/23 15:10
 * @project repast-pro-parent
 * @declaration:
 */
@Service
public class CategoryService {

    @Autowired
    private ProductCateMapper productCateMapper;

    public List<ProductCate> getCateByLevel(Integer level){
        return productCateMapper.getCateByLevel(level);
    };
}
