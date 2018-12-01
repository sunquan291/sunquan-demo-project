package com.zte.mouse.util;

import com.google.gson.Gson;

public class JsonDeserializer
{
    public static <T> T deserializeObject(String json, Class<T> classType)
    {
        T obj = new Gson().fromJson(json, classType);
        return obj;
    }
}
