package com.zte.sunquan.demo.instance;

public enum Person {
    INSTANCE;
    private String name="sunquan";
    public String getName(){
        return this.name;
    }
}
