package com.regina.pro.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Date Create in 2019/11/20 12:00
 * @Description：
 *     @Accessors(chain = true)链条式调用
 *     需要写一个主函数：
 *     public static void main(String[] args){
 *         PageInfos pageInfos = new PageInfos();
 *         pageInfos.setPageNum(123).setPageSize(123).setT(1);
 *     }
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PageInfos<T> {

    /**
     * 当前页码数
     */
    private Integer pageNum;

    /**
     * 每一页显示的条数
     */
    private Integer pageSize;

    /**
     * 需要条件查询的分页数据
     */
    private T t;
}
