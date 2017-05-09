package me.zarktao.service.controller;

import me.zarktao.service.boot.JsonResponseBody;
import me.zarktao.service.models.vo.User;
import me.zarktao.service.service.CacheServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Tao on 2017/3/27.
 * <p>
 * A simple controller for test.
 */

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private CacheServiceTest cacheServiceTest;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @JsonResponseBody
    User hello() {
        return cacheServiceTest.getUser("123");
    }
}
