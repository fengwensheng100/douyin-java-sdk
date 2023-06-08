package io.github.fengwensheng100.life.req;

import lombok.Data;

/**
 * @ClassName VerifyRecordQueryReq
 * @Description: 验券历史查询请求
 * @Author fengwensheng
 * @Date 2023/3/20
 * @Version V1.0
 **/
@Data
public class VerifyRecordQueryReq {

    /**
     * 页大小，取值范围1～20，是否必填：是
     */
    private int size;
    /**
     * 游标，传前一页最后一条记录的游标（首页传0），是否必填：是
     */
    private String cursor;
    /**
     * 企业号商家总店id（验券准备接口中返回），是否必填：是
     */
    private String account_id;
    /**
     * 门店id列表，不传默认返回商家所有门店核销记录，多个值使用,拼接
     */
    private String poi_ids;
    /**
     * 起始时间戳，单位秒，不传表示今天
     */
    private long start_time;
    /**
     * 截止时间戳，单位秒
     */
    private long end_time;
}
