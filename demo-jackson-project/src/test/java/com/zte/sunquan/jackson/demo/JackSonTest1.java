package com.zte.sunquan.jackson.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
 * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
 * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
 * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
 * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
 * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
 */
public class JackSonTest1 {

    @Test
    public void testBean2Json() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User("sunquan", 29, dateFormat.parse("1996-10-01"), "sunquan291@sina.com");
        user.setType(User.Animal.cat);

        Sate sate = new Sate();
        sate.setCount(1);
        sate.setType("A");
        user.setSate(sate);

        ObjectMapper mapper = new ObjectMapper();
        //枚举值序列时使用index值，如User的type
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, true);
        //User类转JSON
        String json = mapper.writeValueAsString(user);
        System.out.println(json);
    }

    @Test
    public void testJson2Bean() throws IOException {
        String json = "{\"user-name\":\"sunquan\",\"age\":29,\"birthday\":\"1996-10-01 00:00:00\",\"email\":\"sunquan291@sina.com\",\"type\":1,\"user_count\":1,\"user_type\":\"A\"}";
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, true);
        User user = mapper.readValue(json, User.class);
        System.out.println(user);
    }
}
