package com.regina.pro.mapper;

import com.regina.pro.domain.ProductCate;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProductCateMapper extends Mapper<ProductCate> {

    List<ProductCate> getCateByLevel(Integer level);
}