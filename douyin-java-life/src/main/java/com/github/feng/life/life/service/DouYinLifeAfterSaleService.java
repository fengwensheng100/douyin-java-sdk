package com.github.feng.life.life.service;

public interface DouYinLifeAfterSaleService {

    /**
     * 拒绝接单接口
     *
     * @return
     */
    void afterSaleOrderMerchantReject();

    /**
     * 商家取消订单接口
     */
    void afterSaleOrderApplyRefund();

    /**
     * 确认订单接口
     */
    void tradeBuyMerchantConfirmOrder();

    /**
     * 订单查询接口
     */
    void tradeOrderQuery();

    /**
     * 商家同意/拒绝退款接口
     */
    void afterSaleAuditNotify();

    /**
     * 自配送-回传配送信息接口
     */
    void fulfilmentDistributionOrderSyncStatus();
}
