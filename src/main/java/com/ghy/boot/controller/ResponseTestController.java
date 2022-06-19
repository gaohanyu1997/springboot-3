package com.ghy.boot.controller;

import com.ghy.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;

@Controller
public class ResponseTestController {
    /*
    * 1 浏览器发请求直接返回 xml       [applicatiom/xml]   jacksonXmlConverter
    * 2 如果是ajax请求 返回 json      [application/json]   jacksonJsonConverter
    * 3 如果硅谷app发请求，返回自定义协议数据    [application/x-guigu]   xxxConverter
    *       要求： 属性值1;属性值2;
    *
    * 步骤：
    *   1 添加自定义的MessageConverter进系统底层
    *   2 系统底层每次内容协商时就会统计出所有MessageConverter能操作那些类型
    *   3 客户端内容协商[x-guigu ---> guigu]
    * */
    @ResponseBody
    @GetMapping("/test/person")
    public Person person(){
        Person p = new Person();
        p.setAge(28);
        p.setBirth(new Date());
        p.setUserName("lisi");
        return p;
    }
}
