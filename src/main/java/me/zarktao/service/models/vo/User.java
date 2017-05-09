package me.zarktao.service.models.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by yt005 on 2017/5/9.
 */
public class User {
    String name;
    int age;
    boolean adult;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
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
