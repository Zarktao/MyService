package me.zarktao.service.controller;

import me.zarktao.service.boot.JsonResponseBody;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @JsonResponseBody
    User hello() {
        return new User();
    }

    class User{
        String name;
        int age;
        boolean adult;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public User(){
            name = "a";
            age = 10;
            adult = false;
        }
    }
}
