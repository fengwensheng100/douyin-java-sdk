package com.github.feng.life.life.resp;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName CertificatePrepareResp
 * @Description: 验券准备响应
 * @Author fengwensheng
 * @Date 2022/10/19
 * @Version V1.0
 **/
@Data
public class CertificatePrepareResp {

    /**
     * 错误码，0为成功
     */
    private int error_code;
    /**
     * 错误码描述
     */
    private String description;
    /**
     * 一次验券的标识, 在验券接口传入
     */
    private String verify_token;
    /**
     * 可用团购券列表
     */
    private List<Certificates> certificates;
    @Data
    public static class Certificates{
        /**
         * 加密券码, 在验券接口传入
         */
        private String encrypted_code;
        /**
         * 券码有效期，截至时间，时间戳，单位秒
         */
        private long expire_time;
        /**
         * 团购信息
         */
        private Sku sku;
        @Data
        public static class Sku{
            /**
             * 团购SKU ID
             */
            private String sku_id;
            /**
             * 团购名称
             */
            private String title;
            /**
             * 团购类型（type=1团餐券; type=2代金券; type=3次卡）
             */
            private int groupon_type;
            /**
             * 团购市场价，单位分
             */
            private BigDecimal market_price;
            /**
             * 团购售卖开始时间，时间戳，单位秒
             */
            private long sold_start_time;
            /**
             * 商家系统（第三方）团购id
             */
            private String third_sku_id;
            /**
             * 商家团购账号id
             */
            private String account_id;
        }

        /**
         * 金额信息
         */
        private Amount amount;
        @Data
        public static class Amount{
            /**
             * 券原始金额，单位分
             */
            private BigDecimal original_amount;
            /**
             * 用户实付金额，单位分
             */
            private BigDecimal pay_amount;
            /**
             * 商家营销金额，单位分
             */
            private BigDecimal merchant_ticket_amount;
            /**
             * 支付优惠金额，单位分
             */
            private BigDecimal payment_discount_amount;
            /**
             * 券实付金额（=用户实付金额+支付优惠金额），单位分
             */
            private BigDecimal coupon_pay_amount;
        }

        /**
         * 次卡信息
         */
        private TimeCard time_card;
        @Data
        public static class TimeCard{
            /**
             * 次卡总次数
             */
            private int times_count;
            /**
             * 次卡已使用次数
             */
            private int times_used;
        }
    }
}
