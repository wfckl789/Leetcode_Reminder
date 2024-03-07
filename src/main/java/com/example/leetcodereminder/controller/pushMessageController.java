package com.example.leetcodereminder.controller;

import com.example.leetcodereminder.model.LCProblem;
import com.example.leetcodereminder.service.LeetcodePusher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pushMessageController {
    //要推送的用户openid
    private static String qwb = "oS40l6XW0iEnZpZzoqvCSzDnhN3c";

//    @GetMapping("/push/{name}")
//    public void pushByName(@PathVariable("name") String name) {
//        LeetcodePusher.push(name);
//    }

    @GetMapping("/push/{id}")
    public void pushById(@PathVariable("id") String id) {
        LeetcodePusher.push(id, "", new LCProblem("test", ""));
    }

}
