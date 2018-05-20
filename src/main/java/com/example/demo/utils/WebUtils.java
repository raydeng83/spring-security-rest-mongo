package com.example.demo.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leizhang on 2/25/18.
 */
public class WebUtils {

    public static ResponseEntity successMap(Object obj) {
        Map map = new HashMap<String, Object>();
        map.put("success", true);
        map.put("data", obj);
        return new ResponseEntity(map, HttpStatus.OK);
    }

    public static ResponseEntity createSuccessMap(Object obj) {
        Map map = new HashMap<String, Object>();
        map.put("success", true);
        map.put("data", obj);
        return new ResponseEntity(map, HttpStatus.CREATED);
    }

    public static ResponseEntity failedMap(Object obj) {
        Map map = new HashMap<String, Object>();
        map.put("success", false);
        map.put("data", obj);
        return new ResponseEntity(map, HttpStatus.OK);
    }

    public static ResponseEntity failedMapWithStatus(Object obj, HttpStatus status) {
        Map map = new HashMap<String, Object>();
        map.put("failed", true);
        map.put("data", obj);
        return new ResponseEntity(map, status);
    }
}
