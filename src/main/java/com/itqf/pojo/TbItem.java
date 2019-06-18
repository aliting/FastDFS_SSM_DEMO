package com.itqf.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2019/6/17
 * @Time: 上午11:00
 */
//@Data  //setter  getter   @ToString
    @Setter
    @Getter
    @ToString
public class TbItem {

    private int id;
    private String name;
    private double price;
    private String images;


}
