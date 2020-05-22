package com.example.serviceA.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/api/getUserInfo")
    public Object getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "serviceA");
        return hashMap;
    }
    //rest方式调用serviceB的接口
    @RequestMapping(value = "/getBinfo")
    public Object getBinfo() {
//        String forObject = this.restTemplate.getForObject("http://127.0.0.1:8082/api/getUserInfo", String.class);
//        String s = this.restTemplate.postForObject("http://windows-iivhjs7:8082/api/getUserInfo", null, String.class);
//        System.out.println("调用b服务返回：" +s);

        System.out.println("rest以别名方式调用b服务需要依赖ribbon负载均衡器，在启动类注入restTemplate的时候加上@LoadBalanced注解");
        String tobj = this.restTemplate.postForObject("http://SERVICEB/api/getUserInfo", null, String.class);
        System.out.println("rest以别名方式调用b服务返回：" +tobj);
        return "调用b服务返回：" + tobj + ",端口：" + this.port;
    }

}
