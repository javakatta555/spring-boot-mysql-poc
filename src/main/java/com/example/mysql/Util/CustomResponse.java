package com.example.mysql.Util;

import com.example.mysql.model.MetaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomResponse {

    public static <T> ResponseEntity<Map> ok(T data){
        //Prepare meta info
        MetaResponse metaInfo = getMeta("SUCCESS", false);
        //Prepare response
        Map<String, Object> map = new HashMap<>();
        map.put("meta", metaInfo);
        map.put("data", data);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public static <T>ResponseEntity<Map> ok(){
        MetaResponse metaInfo = getMeta("SUCCESS", false);
        //Prepare response
        Map<String, Object> map = new HashMap<>();
        map.put("meta", metaInfo);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public static MetaResponse getMeta(String msg, boolean isError) {
        MetaResponse metaInfo = new MetaResponse();
        metaInfo.setMsg(msg);
        metaInfo.setError(isError);
        return metaInfo;
    }

    public static ResponseEntity<Map> notfound(String msg) {
        //Prepare meta info
        MetaResponse metaInfo = getMeta(msg, true);
        //Prepare response
        Map<String, Object> map = new HashMap<>();
        map.put("meta", metaInfo);
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    public static <T>ResponseEntity<Map> created(){
        MetaResponse metaInfo = getMeta("SUCCESS", false);
        //Prepare response
        Map<String, Object> map = new HashMap<>();
        map.put("meta", metaInfo);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    public static ResponseEntity<Map> error(String msg){
        //Prepare meta info
        MetaResponse metaInfo = getMeta(msg, true);
        //Prepare response
        Map<String, Object> map = new HashMap<>();
        map.put("meta", metaInfo);
        map.put("data", Collections.emptyList());
        return new ResponseEntity<>(map, HttpStatus.valueOf(500));
    }

    public static ResponseEntity<Map> badRequest(String msg){
        //Prepare meta info
        MetaResponse metaInfo = getMeta(msg, true);
        //Prepare response
        Map<String, Object> map = new HashMap<>();
        map.put("meta", metaInfo);
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }
}
