package com.zte.sunquan.jackson.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zte.sunquan.jackson.demo2.Car;
import com.zte.sunquan.jackson.demo2.Trail;
import org.junit.Test;

import java.io.IOException;

public class JackSonTest3 {

    @Test
    public void test1() throws Exception {
        Trail trail = Trail.of();
        trail.setUserName("sunquan")
                .setVeticle(Car.of("car"));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(trail);
        System.out.println(json);
    }

    @Test
    public void test2() throws IOException {
        String json = "{\"user-name\":\"sunquan\",\"veticle\":{\"@class\":\"car\",\"car-name\":\"car\"}}";
        ObjectMapper mapper = new ObjectMapper();
        Trail trail = mapper.readValue(json, Trail.class);
        System.out.println(trail);
    }
}
