package com.nut.one.comm.utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dolphin on 2015/10/21.
 */
public class HttpUtils {

    private static String url = "http://hq.sinajs.cn/list=sh601006";

    public static String get(String url){

        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        String result = "";
        try {
            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                InputStream is = response.getEntity().getContent();
                result = inStream2String(is);
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String inStream2String(InputStream is) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len = -1;
        while ((len = is.read(buf)) != -1) {
            baos.write(buf, 0, len);
        }
        return new String(baos.toByteArray());
    }

    public static void main(String[] args) {
        String result = get(url);
        String[] res = StringUtils.getRegStringArray(result, "\".+\"", ",");
        System.out.println(res);
    }
}
