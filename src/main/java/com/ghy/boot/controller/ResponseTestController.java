package com.ghy.boot.controller;

import com.ghy.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;

@Controller
public class ResponseTestController {
    @ResponseBody   //给前端自动返回json数据
    @GetMapping("/test/person")
    public Person person(){
        Person p = new Person();
        p.setAge(28);
        p.setBirth(new Date());
        p.setUserName("lisi");
        return p;
    }
}
