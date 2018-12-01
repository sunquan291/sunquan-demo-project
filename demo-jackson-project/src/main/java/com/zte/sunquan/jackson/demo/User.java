package com.zte.sunquan.jackson.demo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
@Getter
@Setter
public class User {
    private String userName;
    private Integer age;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;
    private String email;

    private Type type;//对于枚举，默认输出是name

    @JsonUnwrapped(prefix = "user_")
    private Sate sate;

    public User(String name, Integer age, Date birthday, String email) {
        this.userName = name;
        this.age = age;
        this.birthday = birthday;
        this.email = email;
    }

    enum Type {
        dog(1), cat(2);
        int value;

        Type(int value) {
            this.value = value;
        }
    }
}
