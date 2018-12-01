package com.zte.sunquan.jackson.demo2;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "@class"
)
@JsonSubTypes({
        @JsonSubTypes.Type(
                value = Car.class,
                name = "car"),
        @JsonSubTypes.Type(
                value = Bus.class,
                name = "bus")})
public interface Veticle {
}
