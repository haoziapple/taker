package com.haozi.taker.core.util;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/7/11.
 */
public class HttpUtil {
    private static final String sep = System.getProperty("line.separator");
    public static String readURL(String URLPath) {
        long start = System.currentTimeMillis();
        try {
            URL url = new URL(URLPath);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();

            int responseCode = connect.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("success read httpURL");
                InputStream in = connect.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader bufr = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder("");

                String read;

                while ((read = bufr.readLine()) != null) {
                    sb.append(read).append(sep);
                }
                long end = System.currentTimeMillis();
                long span = end - start;
                System.out.println("读取url用时:" + span + "ms");
                return sb.toString();
            } else {
                System.out.println("fail read httpURL");
            }
        } catch (
                MalformedURLException e)

        {
            e.printStackTrace();
        } catch (
                IOException e)

        {
            e.printStackTrace();
        }

        return null;
    }

}
