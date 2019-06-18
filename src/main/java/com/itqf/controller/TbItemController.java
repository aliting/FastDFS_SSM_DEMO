package com.itqf.controller;

import com.itqf.pojo.TbItem;
import com.itqf.service.TbItemService;
import com.itqf.utils.FastDFSClient;
import com.itqf.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2019/6/17
 * @Time: 上午11:21
 */
@Controller
public class TbItemController {


    @Resource
    private TbItemService tbItemService;

    @RequestMapping("/findAll")
    @ResponseBody
    public R  findAll(){
        List<TbItem> list = tbItemService.findAll();

        return  R.ok().put("tbItems",list);
    }

    /**
     * 案例一
     * @param file
     * @param item
     * @return
     */
    @RequestMapping("/doAdd.do")
    @ResponseBody
    public  R add(@RequestParam(value = "img")MultipartFile file, TbItem item){
        StringBuilder sb = new StringBuilder("http://192.168.82.188/");
        try{
           String filename = file.getOriginalFilename();

           String suffix = filename.substring(filename.lastIndexOf(".")+1);//substrin4);g(1,
           FastDFSClient client = new FastDFSClient("client.conf");
            //上传图片
           String[] s =  client.uploadFile(file.getBytes(),suffix);
           for (int i =0;i<s.length;i++) {//group1   M00/00/00/xxxxxx.jpg
               //group1/M00/00/00/xxxxxx.jpg
              sb.append(s[i]);
              if (i==0){
                  sb.append(File.separator);
              }

           }
           System.out.println("成功"+sb);
           //返回：/group1/M00/00/00/xxxxxx.jpg
           //访问图片：http://192.168.82.188/group1/M00/00/00/xxxxxx.jpg


       }catch(Exception e){
           System.out.println("失败");

            e.printStackTrace();
            return  R.error("失败");
       }

        String images = sb.toString();
        item.setImages(images);

        boolean f = tbItemService.save(item);

        if (f){
            return  R.ok();
        }else{
            return R.error();
        }
    }

    /**
     * 升级版本
     * 处理图片上传
     */
    @RequestMapping("/uploader.do")
    @ResponseBody
    public  R upload(@RequestParam MultipartFile file){
        StringBuilder sb = new StringBuilder("http://192.168.82.188/");
        try{
            String filename = file.getOriginalFilename();

            String suffix = filename.substring(filename.lastIndexOf(".")+1);//substrin4);g(1,
            FastDFSClient client = new FastDFSClient("client.conf");
            //上传图片
            String[] s =  client.uploadFile(file.getBytes(),suffix);
            for (int i =0;i<s.length;i++) {//group1   M00/00/00/xxxxxx.jpg
                //group1/M00/00/00/xxxxxx.jpg
                sb.append(s[i]);
                if (i==0){
                    sb.append(File.separator);
                }

            }
            System.out.println("成功"+sb);
            return R.ok("上传成功").put("path",sb.toString());
        }catch(Exception e){
            e.printStackTrace();
            return R.ok("上传失败");
        }



    }

    /**
     * 商品新增
     */
    @RequestMapping("/doAddTbItem.do")
    @ResponseBody
    public  R addItem(TbItem item){
        boolean f = tbItemService.save(item);
        if (f){
            return R.ok("新增成功");
        }
        return R.error("新增失败");
    }



}
