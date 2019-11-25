package com.regina.pro.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.regina.pro.page.PageInfos;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Regina
 * @data 2019/11/22 1:18
 * @project repast-pro-parent
 * @declaration:
 *   所有service层的基类
 *  *      因为所有的service都要注入mapper
 *  *      现在使用的是通用service--->注入哪一个mapper？
 *  *
 *  *      UserMapper --> Mapper<T>
 *  *          Mapper<T>:
 *  *              Integer add(T t);
 *  *              Integer update(T t);
 *  *              ....
 *  *      UserMapper 继承了通用mapper<T>-->T:实体类
 */
public abstract class BaseService<T> {

    /**
     * @description
     *      T--->代表实体类
     *      Mapper<T>--->实体类
     *      -->UserMapper extends Mapper<T>
     *      注入任意的实体类，返回该实体类所对应的mapper类型
     *      User-->UserMapper
     *      Order-->OderMapper
     * @param []
     * @date 2019/11/20
     * @return tk.mybatis.mapper.common.Mapper<T>
     * @throws
     **/
    public abstract Mapper<T> getMapper();

    /**
     * @description
     *      保存方法
     * @param [t]
     * @date 2019/11/20
     * @return java.lang.Integer
     * @throws
     **/
    public Integer save(T t) throws Exception {
        return getMapper().insert(t);
    }

    /**
     * @description
     *      通过主键进行更新
     * @param [t]
     * @date 2019/11/20
     * @return java.lang.Integer
     * @throws
     **/
    public Integer update(T t) throws Exception {
        return getMapper().updateByPrimaryKey(t);
    }

    /**
     * @description
     *      通过主键进行删除
     * @param [key]
     * @date 2019/11/20
     * @return java.lang.Integer
     * @throws
     **/
    public Integer deleteByPrimaryKey(Object key) throws  Exception {
        return getMapper().deleteByPrimaryKey(key);
    }

    /**
     * @description
     *      通过实体类的属性进行删除
     * @param [t]
     * @date 2019/11/20
     * @return java.lang.Integer
     * @throws
     **/
    public Integer delete(T t) throws  Exception {
        return getMapper().delete(t);
    }

    /**
     * @description
     *      通过主键进行查询
     * @param [key]
     * @date 2019/11/20
     * @return T
     * @throws
     **/
    public T get(Object key) throws Exception {
        return getMapper().selectByPrimaryKey(key);
    }

    /**
     * @description
     *      查询所有数据
     * @param []
     * @date 2019/11/20
     * @return java.util.List<T>
     * @throws
     **/
    public List<T> get() throws Exception {
        return getMapper().selectAll();
    }

    /**
     * @description
     *      根据实体类中的属性进行查询(条件查询--->单数据的条件查询)
     * @param [t]
     * @date 2019/11/20
     * @return T
     * @throws
     **/
    public T selectOne(T t) throws Exception {
        return getMapper().selectOne(t);
    }

    /**
     * @description
     *      根据实体类的属性进行条件查询(多条数据的条件查询)
     * @param [t]
     * @date 2019/11/20
     * @return java.util.List<T>
     * @throws
     **/
    public List<T> selectDomain(T t) throws Exception {
        return getMapper().select(t);
    }

    /**
     * @description
     *      带条件的分页查询
     * @param [t, pageInfos]
     * @date 2019/11/20
     * @return java.util.List<T>
     * @throws
     **/
    public List<T> selectPage(T t, PageInfos<T> pageInfos) throws Exception {
        return getMapper().selectByRowBounds(t, new RowBounds(pageInfos.getPageNum(), pageInfos.getPageSize()));
    }

    /**
     * @description
     *      带条件的数量查询，如果需要查询所有数量，则直接传null
     * @param [t]
     * @date 2019/11/20
     * @return java.lang.Integer
     * @throws
     **/
    public Integer selectCount(T t) throws Exception {
        return getMapper().selectCount(t);
    }

    /**
     * @description
     *      根据实体类中的属性进行分页查询
     * @param [pageInfos]
     * @date 2019/11/20
     * @return com.github.pagehelper.PageInfo<T>
     * @throws
     **/
    public PageInfo<T> selectPageInfo(PageInfos<T> pageInfos) throws Exception {
        /**
         * pageInfos.getPageNum == null
         * 说明是第一次点击进入，获取不到当前的页码数，则直接赋值为0
         */
        if(pageInfos.getPageNum() == null) {
            pageInfos.setPageNum(0);
        }
        // select * from user limit 0,3
        PageHelper.startPage(pageInfos.getPageNum(), pageInfos.getPageSize());
        List<T> list = this.selectDomain(pageInfos.getT());
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        pageInfo.setTotal(this.selectCount(pageInfos.getT()));
        return pageInfo;
    }

}

