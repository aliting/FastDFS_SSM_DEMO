package com.itqf.service;

import com.itqf.pojo.TbItem;

import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2019/6/17
 * @Time: 上午11:18
 */
public interface TbItemService {

    public List<TbItem>  findAll();

    public  boolean save(TbItem item);


}
