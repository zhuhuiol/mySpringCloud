package com.example.serviceB.api.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
public class UserInfoRestService {

    @RequestMapping(value = "/api/getUserInfo")
    public Object getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "serviceB");
        return hashMap;
    }
}
