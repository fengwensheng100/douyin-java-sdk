package io.github.feng.common.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HttpUtils
 * @Description: TODO
 * @Author fengwensheng
 * @Date 2023/3/20
 * @Version V1.0
 **/
public class DouYinHttpUtils extends HttpUtils {

    public static String get(String url, String json, String contentType, String token) throws Exception {
        Map<String, String> headers = new HashMap<>();
        headers.put("access-token", token);
        headers.put("Content-Type", contentType);
        return http(url, json, METHOD_GET, headers);
    }

    public static String post(String url, String json, String contentType, String token) throws Exception {
        Map<String, String> headers = new HashMap<>();
        headers.put("access-token", token);
        headers.put("Content-Type", contentType);
        return http(url, json, METHOD_POST, headers);
    }

    /**
     * 获取抖音url参数
     * @param url
     * @param key
     * @return
     */
    public static String getDouYinUrlParams(String url, String key) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(10000).build();
        httpGet.setConfig(defaultRequestConfig);

        HttpContext httpContext = new BasicHttpContext();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        httpclient.execute(httpGet, httpContext);

        HttpUriRequest req = (HttpUriRequest) httpContext.getAttribute(ExecutionContext.HTTP_REQUEST);
        String query = req.getURI().getQuery();
        String[] strings = query.split("&");
        for (String params : strings) {
            String[] kv = params.split("=");
            if (kv.length > 1 && kv[0].equals(key)) {
                return kv[1];
            }
        }
        return null;
    }
}
