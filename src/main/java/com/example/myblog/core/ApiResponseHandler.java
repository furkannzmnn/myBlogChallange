package com.example.myblog.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ApiResponseHandler {

    public static ResponseEntity<Object> jsonGenerateResponse(String messageDetails,
                                                              HttpStatus httpCode,
                                                              Object data){
        Map<String , Object> map = new HashMap<>();

        map.put("message:" , messageDetails);
        map.put("httpCode:" , httpCode.value());
        map.put("data" , data);

        return new ResponseEntity<>(map, httpCode);
    }
}
