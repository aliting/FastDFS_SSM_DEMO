package com.itqf.mapper;

import com.itqf.pojo.TbItem;

import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2019/6/17
 * @Time: 上午11:05
 */
public interface TbItemMapper {
    public int saveItem(TbItem tbItem);


    public List<TbItem> findAll();


}
