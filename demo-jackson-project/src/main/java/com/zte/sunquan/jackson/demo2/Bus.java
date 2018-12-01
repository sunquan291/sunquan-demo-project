package com.zte.sunquan.jackson.demo2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "class")
public class Bus implements Veticle {
}
