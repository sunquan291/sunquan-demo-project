package com.zte.sunquan.jackson.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zte.sunquan.jackson.demo2.Car;
import com.zte.sunquan.jackson.demo2.Trail;
import org.junit.Test;

import java.io.IOException;

public class JackSonTest3 {

    @Test
    public void test1() throws Exception {
        Trail trail = Trail.of();
        trail.setUserName("sunquan")
                .setVeticle(Car.of("car"))
        //.setType(Car.class)
        ;

        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, true);
        String json = mapper.writeValueAsString(trail);
        System.out.println(json);
    }

    @Test
    public void test2() throws IOException {
        String json="{\"user-name\":\"sunquan\",\"veticle\":{\"@class\":\"car\",\"car-name\":\"car\"}}";
        ObjectMapper mapper = new ObjectMapper();
        Trail trail = mapper.readValue(json, Trail.class);
        System.out.println(trail);
    }
}
