package pers.peixinyi.utils;

import io.netty.handler.codec.http.HttpStatusClass;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Description: 调用Http
 * @Author: PeiXy
 * @Date: 2021-01-21 15:07
 */
public class InvokingHttp {
    /**
     * TODO 请求记得传参数
     *
     * @param method
     * @param url
     * @return
     */
    public static String invoking(String method, String url) {
        CloseableHttpClient request = HttpClientBuilder.create().build();
        switch (method) {
            case "GET":
                return get(request, url);
            case "POST":
                return post(request, url);
            default:
                return null;
        }
    }

    public static String get(CloseableHttpClient request, String url) {
        System.out.println("当前访问地址为:" + url);
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = request.execute(get);
            HttpEntity httpEntity = response.getEntity();
            return EntityUtils.toString(httpEntity, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                request.close();
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String post(CloseableHttpClient request, String url) {
        return null;
    }

}
