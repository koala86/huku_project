package com.namu.huku_spring.controller;

import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.namu.huku_spring.entity.User;

@CrossOrigin
@RestController
public class Index {
    
    @GetMapping("/index")
    public String index() {
        String nowTime = LocalDateTime.now().toString();
        return "good" + nowTime;
    }

    @PostMapping("/test")
    public String test(@RequestBody User user) {

        String url = "http://127.0.0.1:8000/api/analysis/" + user.getUsername() + "/" + user.getPassword()+ "/";
        JSONObject jsonObject = new JSONObject();
        String responseJson=null;
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity httpEntity = new HttpEntity(jsonObject,headers);

        try {
            ResponseEntity<String> responseBody = template.exchange(url, HttpMethod.GET,httpEntity,String.class);
            //解析返回的数据
            JSONObject jsTemp = JSONObject.parseObject(responseBody.getBody());
            responseJson=jsTemp.toJSONString();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("============================");
        System.out.println(responseJson);
        return responseJson;
    }
}
