package com.zte.sunquan.jackson.demo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
@NoArgsConstructor
@ToString
public class User {
    private String userName;
    private Integer age;
    //序列化时采用jsonFormat中格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;
    private String email;
    //对于枚举，默认输出是name
    private Animal type;

    //针对State的序列化不包装只加前缀"sate":{"count":1,"type":"A"}}
    //"user_count":1,"user_type":"A"  建议在对象里字段不多时，可以使用
    @JsonUnwrapped(prefix = "user_")
    private Sate sate;

    public User(String name, Integer age, Date birthday, String email) {
        this.userName = name;
        this.age = age;
        this.birthday = birthday;
        this.email = email;
    }

    enum Animal {
        dog(1), cat(2);
        int value;

        Animal(int value) {
            this.value = value;
        }
    }
}
