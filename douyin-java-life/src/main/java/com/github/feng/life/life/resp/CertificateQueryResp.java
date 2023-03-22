package com.github.feng.life.life.resp;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName CertificateQueryResp
 * @Description: 券状态批量查询响应
 * @Author fengwensheng
 * @Date 2022/10/19
 * @Version V1.0
 **/
@Data
public class CertificateQueryResp {

    /**
     * 错误码，0为成功
     */
    private int error_code;
    /**
     * 错误码描述
     */
    private String description;
    /**
     * 可用团购券列表
     */
    private List<Certificate> certificates;
    @Data
    public static class Certificate{
        /**
         * 加密券码, 在验券接口传入
         */
        private String encrypted_code;
        /**
         * 券的状态， 0表示初始状态，1 表示未使用，2表示已使用，
         * 3表示退款申请中（待审核），4表示退款成功，5表示退款失败，6表示退款中
         */
        private long status;
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
        }
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
             * 商家系统（第三方）团购id
             */
            private String third_sku_id;
            /**
             * 商家团购账号id
             */
            private String account_id;
            /**
             * 团购类型（type=1团餐券; type=2代金券）
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
        }
        /**
         * 券码有效期，截至时间，时间戳，单位秒
         */
        private long expire_time;
        /**
         * 券码(未核销时不返回、已核销可撤销时不返回)
         */
        private String code;
        /**
         * 最近核销信息，未核销为空，已撤销为空
         */
        private Verify verify;
        @Data
        public static class Verify{
            /**
             * 核销记录ID
             */
            private String verify_id;
            /**
             * 券ID
             */
            private String certificate_id;
            /**
             * 核销类型，0默认值，1用户自验，2商家扫二维码，3商家手动输入，4开放平台API
             */
            private int verify_type;
            /**
             * 核销时间， 单位秒，时间戳
             */
            private long verify_time;
            /**
             * 是否可撤销
             */
            private boolean can_cancel;
            /**
             * 核销人抖音号（当核销类型verify_type=4时，默认为"开放平台API")
             */
            private String verifier_unique_id;
        }
    }
}
