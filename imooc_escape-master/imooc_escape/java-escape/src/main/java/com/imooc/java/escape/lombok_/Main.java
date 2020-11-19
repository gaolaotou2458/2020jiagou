package com.imooc.java.escape.lombok_;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <h1>lombok 工具的使用以及需要避免的坑</h1>
 * */
public class Main {

    /**
     * <h1>lombok 第一个坑</h1>
     * 通过Jackson 序列化和反序列化
     * 单字母驼峰 解析失败
     * 避免单字母驼峰，要符合java命名规范
     * */
    private static void singleAlphabetHump() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Personal personal = new Personal();
        personal.setIPhone("8.1");
        System.out.println(mapper.writeValueAsString(personal));
        //{"name":null,"userName":null,"iphone":"8.1"}
        String json = "{\"name\":null,\"userName\":null,\"iPhone\":\"8.1\"}";
        //用jackson解析就失败了
//        Personal personal1 = mapper.readValue(json, Personal.class);

        Personal personal2 = JSONUtil.toBean(json, Personal.class);
        System.out.println(personal2);


    }

    /**
     * <h2>lombok 的第二个坑</h2>、
     * @Data注解的 equals方法
     * 不用 //@EqualsAndHashCode(callSuper = true) 注解
     * 不会比较父类的属性
     * */
    private static void equalsAndHashCodeBug() {

        AppleComputer computer1 = new AppleComputer(
                1, "Mac Pro", 1L, "yellow"
        );
        AppleComputer computer2 = new AppleComputer(
                2, "Mac Air", 1L, "yellow"
        );

        System.out.println(computer1.equals(computer2)); //
    }

    public static void main(String[] args) throws Exception {
        //singleAlphabetHump();
        equalsAndHashCodeBug();

    }
}
