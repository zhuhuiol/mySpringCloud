package com.homolo.homolo.restApi;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserInfoRestService {

    @RequestMapping(value = "/api/getUserInfo")
    public Object getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        JSONArray jsonArray = new JSONArray();
        JSONObject object = new JSONObject();
        object.put("username", "zhangsan");
        object.put("usernike", "hhh");
        object.put("mobile", "15022323367");
        jsonArray.put(object);
        return jsonArray.toString();
    }
}
