package com.ghy.boot.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/params")
    public String test(Map<String,Object> map,
                       Model model,
                       HttpServletRequest request,
                       HttpServletResponse response){
        map.put("hello","hello666");
        model.addAttribute("world","world666");
        request.setAttribute("message","message666");
        Cookie cookie = new Cookie("c1","v1");
        response.addCookie(cookie);
        return "forward:/mapsuccess";
    }

    @ResponseBody
    @GetMapping("/mapsuccess")
    public Map success(HttpServletRequest request){
        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");
        Map<String,Object> map = new HashMap<>();
        map.put("hello",hello);
        map.put("world",world);
        map.put("message",message);
        return map;
    }

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg","成功了");
        request.setAttribute("code",200);
        return "forward:/success";  //转发到 /success请求
    }

    /*@ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                        @RequestAttribute("code") Integer code,
                        HttpServletRequest request){
        Object msg1 = request.getAttribute("msg");
        Object code1 = request.getAttribute("code");
        Map<String,Object> map = new HashMap<>();
        //request取到的值
        map.put("request_msg",msg1);
        map.put("request_code1",code1);
        //@RequestAttribute 注解取到的值
        map.put("annotation_msg",msg);
        map.put("annotation_code",code);
        return map;
    }*/
}
