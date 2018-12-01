package com.zte.mouse.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

public class PropsUtil
{
    public static final String filePath = "/conf/prop.properties";

    public static String readValue(String key)
    {
        Properties props = new Properties();
        try
        {
            InputStream in = PropsUtil.class.getResourceAsStream(filePath);
            props.load(in);
            String value = props.getProperty(key);
            return value;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "0";
        }
    }

    public static void readProperties(String filePath)
    {
        Properties props = new Properties();
        try
        {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            props.load(in);
            Enumeration<?> en = props.propertyNames();
            while (en.hasMoreElements())
            {
                String key = (String) en.nextElement();
                String Property = props.getProperty(key);
                System.out.println(key + "==" + Property);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void writeDataToFile(String time, String bat)
    {
        Properties prop = new Properties();
        try
        {
            InputStream fis = new FileInputStream(filePath);
            prop.load(fis);
            OutputStream fos = new FileOutputStream(filePath);
            prop.setProperty("time", time);
            prop.setProperty("bat", bat);
            prop.store(fos, "Update '" + 2 + "' value");
            fis.close();
            fos.flush();
            fis.close();
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
