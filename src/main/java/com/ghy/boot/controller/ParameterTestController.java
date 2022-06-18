package com.ghy.boot.controller;
import com.ghy.boot.bean.Person;
import org.springframework.web.bind.annotation.*;
import sun.awt.image.IntegerComponentRaster;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {
    //数据绑定：页面提交的请求数据(GET、POST)都可以和对象属性进行绑定
    @PostMapping("/saveuser")
    public Person saveUser(Person person){
        return person;
    }

    // car/2/owner/zhangsan  @PathVariable：路径变量
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String,String> pv){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        return map;
    }

    @GetMapping("/head")    // @RequestHeader 获取请求头
    public Map<String,Object> requestHead(@RequestHeader("User-Agent") String userAgent,
                                          @RequestHeader Map<String,String> head){
        Map<String,Object> map = new HashMap<>();
        map.put("userAgent",userAgent);
        map.put("head",head);
        return map;
    }

    @GetMapping("/param")   // @RequestHeader 获取请求参数
    public Map<String,Object> requestParam(@RequestParam("age") Integer age,
                                           @RequestParam List<String> inters,
                                           @RequestParam Map<String,String> params){
        Map<String,Object> map = new HashMap<>();
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        return map;
    }

    @GetMapping("/cookie")   // @CookieValue 获取cookie值
    public Map<String,Object> cookieValue(@CookieValue("_ga") String _ga,
                                          @CookieValue("_ga") Cookie cookie){
        Map<String,Object> map = new HashMap<>();
        map.put("_ga",_ga);
        System.out.println(cookie);
        System.out.println(cookie.getName()+"===>"+cookie.getValue());
        return map;
    }

    @PostMapping("/save")   //@RequestBody(获取请求体[POST])
    public Map<String,Object> postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }

    //1、语法： /cars/sell;low=34;brand=byd,audi,yd
    //2 springboot默认是禁用了矩阵变量的功能 需手动开启
    // 手动开启：原理 对于路径的处理 UrlPathHelper进行解析。
    // removeSemicolonContent(移除分号内容)支持矩阵变量的
    //3 矩阵变量必须有url路径变量才能被解析
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

    //  /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String,Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }
}
