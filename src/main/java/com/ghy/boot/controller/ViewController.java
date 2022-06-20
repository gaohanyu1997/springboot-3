package com.ghy.boot.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/atguigu")
    public String atgugui(Model model){
        //model 中的数据会被放在请求域中 request.setAttribute("a",aa)
        model.addAttribute("msg","你好");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
