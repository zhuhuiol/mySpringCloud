package com.example.serviceA.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
public class UserInfoRestService {

    // RestTemplate方式调用,底层使用httpClient技术
    //直接注入会失败，因为并没有在spring中注册，需要在启动类里面注册
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/api/getUserInfo")
    public Object getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "serviceA");
        return hashMap;
    }
    //调用serviceB的接口
    @RequestMapping(value = "/getBinfo")
    public Object getBinfo() {
//        String forObject = this.restTemplate.getForObject("http://localhost:8082/api/getUserInfo", String.class);
        String forObject = this.restTemplate.getForObject("http://windows-iivhjs7:8082/api/getUserInfo", String.class);

        return "调用b服务返回：" + forObject;
    }

}
