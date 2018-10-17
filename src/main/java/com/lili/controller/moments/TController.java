package com.lili.controller.moments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liqiao on 2018/10/8.
 */
@Controller
@RequestMapping("/server/test")
public class TController {
    @GetMapping
    public String test() {

        return "test";
    }
    @GetMapping("/value")
    @ResponseBody
    public String value(@RequestParam("name") String name) throws InterruptedException {
        Thread.sleep(10000);
        return name;
    }

    @GetMapping("/noValue")
    @ResponseBody
    public void noValue() {


    }
    @GetMapping("/getMoney")
    @ResponseBody
    public int noValue(@RequestParam("name")String name) {
        if ("A".equals(name)) {
            return 100;
        } else if ("B".equals(name)) {
            return 200;
        } else if ("C".equals(name)) {
            return 300;
        } else {
            return 400;
        }

    }
}
