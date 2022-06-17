package com.ghy.boot.controller;
import org.springframework.web.bind.annotation.*;
import sun.awt.image.IntegerComponentRaster;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {
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
}
