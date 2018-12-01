package com.zte.sunquan.jackson.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JackSonTest1 {

    @Test
    public void testBean2Json() throws Exception {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User("sunquan", 29, dateformat.parse("1996-10-01"), "sunquan291@sina.com");
        user.setType(User.Type.cat);
        Sate sate=new Sate();
        sate.setCount(1);
        sate.setType("A");
        user.setSate(sate);

//        User user = new User();
//        user.setName("zhangsan");
//        user.setEmail("zhangsan@163.com");
//        user.setAge(20);
//
//        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
//
//        user.setBirthday(dateformat.parse("1996-10-01"));

        /**
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
         * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
         * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
         * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
         */
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX,true);
        //User类转JSON
        //输出结果：{"name":"zhangsan","age":20,"birthday":844099200000,"email":"zhangsan@163.com"}
        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        //Java集合转JSON
        //输出结果：[{"name":"zhangsan","age":20,"birthday":844099200000,"email":"zhangsan@163.com"}]
        List<User> users = new ArrayList<User>();
        users.add(user);
        String jsonlist = mapper.writeValueAsString(users);
        System.out.println(jsonlist);
    }
}
