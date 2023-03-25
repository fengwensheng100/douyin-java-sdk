package com.github.feng.life.resp;

import lombok.Data;

import java.util.List;

/**
 * @ClassName ShopPoiQueryResp
 * @Description: 门店信息查询响应
 * @Author fengwensheng
 * @Date 2022/10/19
 * @Version V1.0
 **/
@Data
public class ShopPoiQueryResp {

    /**
     * 错误码，0为成功
     */
    private int error_code;
    /**
     * 错误码描述
     */
    private String description;
    /**
     * 门店账户总条数
     */
    private int total;
    /**
     * 门店信息列表
     */
    private List<Pois> pois;
    @Data
    public static class Pois {
        /**
         * 门店信息
         */
        private Poi poi;
        @Data
        public static class Poi {
            /**
             * 门店POI ID
             */
            private String poi_id;
            /**
             * 门店POI名称
             */
            private String poi_name;
            /**
             * 门店地址
             */
            private String address;
            /**
             * 门店POI经度
             */
            private double latitude;
            /**
             * 门店POI纬度
             */
            private double longitude;
        }
    }
}
