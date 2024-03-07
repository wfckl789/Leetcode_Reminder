package com.example.leetcodereminder.model;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class LCProblem {
    String name = "";
    String difficulty = "";

    public String getName() {
        return name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public LCProblem(String name, String difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }
//    public static JSONObject getLC() {
//        JSONObject lc = new JSONObject();
//        lc.put("name", "contains-duplicate-ii");
//        lc.put("difficulty", "Easy");
////        try {
////            刷题列表接口里获取
////        } catch (Exception e) {
////
////        }
//        return lc;
//    }


}
