package com.github.feng.life.req;

import lombok.Data;

/**
 * @ClassName LedgerDetailedQueryReq
 * @Description: 账单详细查询请求
 * @Author fengwensheng
 * @Date 2023/1/30
 * @Version V1.0
 **/
@Data
public class LedgerDetailedQueryReq {

    /**
     * 页大小，取值范围1～50，是否必填：是
     */
    private int size;
    /**
     * 查询游标，第一页查询传0，翻页查使用上一次查询返回cursor，是否必填：是
     */
    private String cursor;
    /**
     * 商户id，是否必填：是
     */
    private String account_id;
    /**
     * 核销日期，格式为"2006-01-02"，是否必填：是
     */
    private String bill_date;
}
