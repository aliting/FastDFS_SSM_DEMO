package com.itqf.service.impl;

import com.itqf.mapper.TbItemMapper;
import com.itqf.pojo.TbItem;
import com.itqf.service.TbItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2019/6/17
 * @Time: 上午11:19
 */
@Service
public class TbItemServiceImpl implements TbItemService {

    @Resource
    private TbItemMapper tbItemMapper;


    public List<TbItem> findAll() {
        return tbItemMapper.findAll();
    }

    public boolean save(TbItem item) {
        int i = tbItemMapper.saveItem(item);

        return i>0;
    }
}
