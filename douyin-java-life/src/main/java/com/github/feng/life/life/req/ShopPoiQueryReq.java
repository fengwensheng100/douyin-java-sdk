package com.github.feng.life.life.req;

import lombok.Data;

/**
 * @ClassName ShopPoiQueryReq
 * @Description: 门店信息查询请求
 * @Author fengwensheng
 * @Date 2022/10/19
 * @Version V1.0
 **/
@Data
public class ShopPoiQueryReq {

    /**
     * 本地生活账户ID
     */
    private String account_id;
    /**
     * 三方ID
     */
    private String third_id;
    /**
     * 抖音门店POI_ID
     */
    private String poi_id;
    /**
     * 页码 （从1开始）
     */
    private int page;
    /**
     * 页大小
     */
    private int size;
}
