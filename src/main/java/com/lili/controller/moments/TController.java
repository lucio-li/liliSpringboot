package com.lili.controller.moments;

import com.lili.common.dto.ServiceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liqiao on 2018/10/8.
 */
@RestController
@RequestMapping("/server/test")
public class TController {
    @GetMapping
    public ServiceResponse newOneCatalog() {

        return ServiceResponse.createBySuccessMsgData("21", "asd");
    }
}
