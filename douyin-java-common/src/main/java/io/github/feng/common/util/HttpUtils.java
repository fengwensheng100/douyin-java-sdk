package io.github.feng.common.util;

import cn.hutool.core.map.MapUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName HttpUtils
 * @Description: TODO
 * @Author fengwensheng
 * @Date 2023/3/20
 * @Version V1.0
 **/
public class HttpUtils {

    public static String METHOD_GET = "GET";
    public static String METHOD_POST = "POST";
    public static String METHOD_PUT = "PUT";
    public static String METHOD_DELETE = "DELETE";
    public static String CHARSET_UTF8 = "UTF-8";
    public static String APPLICATION_JSON = "application/json";
    public static String APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";

    public static String http(String url, String json, String method, Map<String, String> headers) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        try {
            if (method.equals(HttpPost.METHOD_NAME)) {
                HttpPost httpPost = new HttpPost(url);
                if (MapUtil.isNotEmpty(headers)) {
                    Iterator<String> iterator = headers.keySet().iterator();
                    while (iterator.hasNext()) {
                        String next = iterator.next();
                        httpPost.addHeader(new BasicHeader(next, headers.get(next)));
                    }
                }
                httpPost.setEntity(new StringEntity(json,CHARSET_UTF8));
                response = httpClient.execute(httpPost);
                HttpEntity responseEntity = response.getEntity();
                String result = EntityUtils.toString(responseEntity, CHARSET_UTF8);
                return result;
            } else if (method.equals(HttpGet.METHOD_NAME)) {
                HttpGet httpGet = new HttpGet(url);
                if (MapUtil.isNotEmpty(headers)) {
                    Iterator<String> iterator = headers.keySet().iterator();
                    while (iterator.hasNext()) {
                        String next = iterator.next();
                        httpGet.addHeader(new BasicHeader(next, headers.get(next)));
                    }
                }
                response = httpClient.execute(httpGet);
                HttpEntity responseEntity = response.getEntity();
                String result = EntityUtils.toString(responseEntity, CHARSET_UTF8);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null)
                httpClient.close();
            if (response != null)
                response.close();
        }
        return null;
    }

    public static String http(String url, String json, String method, String contentType, Map<String, String> headers) throws Exception {
        headers.put("Content-Type", contentType);
        return http(url, json, method, headers);
    }

    public static String http(String url, String json, String method, String contentType) throws Exception {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", contentType);
        return http(url, json, method, headers);
    }

    public static String http(String url, String json, String method) throws Exception {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", APPLICATION_JSON);
        return http(url, json, method, headers);
    }

    public static String get(String url, String json, String contentType, Map<String, String> headers) throws Exception {
        headers.put("Content-Type", contentType);
        return http(url, json, METHOD_GET, headers);
    }

    public static String get(String url, String json, String contentType) throws Exception {
        return http(url, json, METHOD_GET, contentType);
    }

    public static String get(String url, String json) throws Exception {
        return http(url, json, METHOD_GET);
    }

    public static String post(String url, String json, String contentType, Map<String, String> headers) throws Exception {
        headers.put("Content-Type", contentType);
        return http(url, json, METHOD_POST, headers);
    }

    public static String post(String url, String json, String contentType) throws Exception {
        return http(url, json, METHOD_POST, contentType);
    }

    public static String post(String url, String json) throws Exception {
        return http(url, json, METHOD_POST);
    }

    public static String mapToUrlParams(Map<String, Object> data) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> iterator = data.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            stringBuilder.append(key + "=" + data.get(key) + "&");
        }
        return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
    }
}
