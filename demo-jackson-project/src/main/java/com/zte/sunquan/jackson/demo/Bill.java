package com.zte.sunquan.jackson.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data(staticConstructor = "of")
@EqualsAndHashCode(of = {"id"})
public class Bill {
    private int id;
    private double cost;
    private String name;
}
