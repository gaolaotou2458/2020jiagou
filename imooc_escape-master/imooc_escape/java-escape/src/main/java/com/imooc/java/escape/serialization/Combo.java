package com.imooc.java.escape.serialization;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <h1>类中存在引用对象</h1>
 * 组合类没实现序列化，则序列化失败
 * */
@Getter
@Setter
public class Combo implements Serializable {

    private int id;
    private People people;

    public Combo(int id, People people) {
        this.id = id;
        this.people = people;
    }
}
