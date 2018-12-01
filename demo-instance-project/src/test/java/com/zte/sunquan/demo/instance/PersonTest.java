package com.zte.sunquan.demo.instance;

import org.junit.Test;

public class PersonTest {
    @Test
    public void test(){
        //使用枚举进行单例的构造
        String name = Person.INSTANCE.getName();
        System.out.println(name);
    }
}
