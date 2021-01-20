package pers.peixinyi.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Description:
 * @Author: PeiXy
 * @Date: 2021-01-20 22:57
 */
public class HttpClientDemo {
    public static void main(String[] args) {
        //得到一个浏览器
        CloseableHttpClient request = HttpClientBuilder.create().build();
//        HttpGet get = new HttpGet("http://www.baidu.com");
        HttpGet get = new HttpGet("http://127.0.0.1:8801");
        CloseableHttpResponse response = null;

        try {
            response = request.execute(get);
            HttpEntity httpEntity = response.getEntity();
            System.out.println(response.getStatusLine());
            if (httpEntity != null) {
                System.out.println(httpEntity.getContentLength());
                System.out.println(ContentType.get(httpEntity));
                System.out.println(EntityUtils.toString(httpEntity, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                request.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
