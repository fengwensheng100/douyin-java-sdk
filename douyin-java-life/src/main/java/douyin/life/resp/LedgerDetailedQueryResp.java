package douyin.life.resp;

import lombok.Data;

import java.util.List;

/**
 * @ClassName DetailedQueryResp
 * @Description: TODO
 * @Author fengwensheng
 * @Date 2023/1/30
 * @Version V1.0
 **/
@Data
public class LedgerDetailedQueryResp {

    /**
     * 若有下页，通过此cursor查询下一页
     */
    private String cursor;
    /**
     * 是否有下一页
     */
    private boolean has_more;
    /**
     * 分账明细列表
     */
    private List<LedgerRecords> ledger_records;
    @Data
    static class LedgerRecords {
        /**
         * 分账商家账户id
         */
        private String account_id;
        /**
         * 金额
         */
        private Amount amount;
        @Data
        static class Amount {
            /**
             * 实际保费，单位分，保险公司扣除的，不存在时为0
             */
            private int actual_insured;
            /**
             * 券码实付金额，单位分，等于用户实付 + 支付优惠，不存在时为0
             */
            private int coupon_pay;
            /**
             * 商家货款，单位分，商家最终提现金额，不存在时为0
             */
            private int goods;
            /**
             * 机构佣金，单位分，不存在时为0
             */
            private int institution_commission;
            /**
             * 实际参与分账的平台优惠券金额，单位分，不存在时为0
             */
            private int ledger_platform_ticket;
            /**
             * 参与分账的总金额，单位分，等于实付金额+实际参与分账的平台优惠券金额+支付渠道优惠，不存在时为0
             */
            private int ledger_total;
            /**
             * 商家优惠券金额，单位分，不存在时为0
             */
            private int merchant_ticket;
            /**
             * 原始金额，单位分，等于实付金额+平台优惠券金额+商家优惠券金额+支付渠道优惠，不存在时为0
             */
            private int original;
            /**
             * 实付金额，单位分，不存在时为0
             */
            private int pay;
            /**
             * 支付渠道优惠，单位分，不存在时为0
             */
            private int pay_discount;
            /**
             * 平台优惠券金额，单位分，不存在时为0
             */
            private int platform_ticket;
            /**
             * 达人佣金，单位分，不存在时为0
             */
            private int talent_commission;
            /**
             * 服务商分佣总金额，单位分，不存在时为0
             */
            private int total_agent_merchant;
            /**
             * 总的商家平台服务费，单位分，等于支付手续费 + 商家平台抽佣，不存在时为0
             */
            private int total_merchant_platform_service;
            /**
             * 代运营服务商总佣金，单位分，需要合并计算时：等于服务商佣金 + 达人佣金；其他场景：等于服务商佣金，不存在时为0
             */
            private int total_operation_agent;
        }

        /**
         *
         */
        private Certificate certificate;
        @Data
        static class Certificate {
            /**
             * 券id，不存在时不返回
             */
            private String certificate_id;
            /**
             * 券码，不存在时不返回
             */
            private String code;
        }

        /**
         * 商品信息
         */
        private Goods goods;
        @Data
        static class Goods {
            /**
             * 团购名称，不存在时不返回
             */
            private String group_name;
            /**
             * skuid
             */
            private String sku_id;
            /**
             * 团购售卖开始时间，秒级时间戳
             */
            private String sold_start_time;
        }
    }
}
