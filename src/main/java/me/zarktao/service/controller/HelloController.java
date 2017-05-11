package me.zarktao.service.controller;

import me.zarktao.service.boot.JsonResponseBody;
import me.zarktao.service.dao.TestMapper;
import me.zarktao.service.models.po.Test;
import me.zarktao.service.models.vo.User;
import me.zarktao.service.service.CacheServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private TestMapper testMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @JsonResponseBody
    User hello() {
        return cacheServiceTest.getUser("123");
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @JsonResponseBody
    List<Test> test() {
        return testMapper.selectAll();
    }
}
