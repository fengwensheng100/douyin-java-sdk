package com.github.feng.life.resp;

import lombok.Data;

import java.util.List;

/**
 * @ClassName PoiMatchRelationQuery
 * @Description: 查询匹配关系响应
 * @Author fengwensheng
 * @Date 2023/3/22
 * @Version V1.0
 **/
@Data
public class PoiMatchRelationQuery {

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
    private List<Relations> relations;
    @Data
    public static class Relations {
        /**
         * 门店POI ID
         */
        private String ext_id;
        /**
         * 门店POI名称
         */
        private String match_poi_id;
        /**
         * 门店地址
         */
        private String match_relation_status;
    }
}
