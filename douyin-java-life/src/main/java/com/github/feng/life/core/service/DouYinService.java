package com.github.feng.life.core.service;

import com.github.feng.life.life.service.*;

public interface DouYinService {

    DouYinCouponLedgerService getDouYinCouponLedgerService();

    DouYinCouponService getDouYinCouponService();

    DouYinMemberService getDouYinMemberService();

    DouYinShopService getDouYinShopService();

    DouYinAfterSaleService getDouYinAfterSaleService();

    Object getService(String name);

    /**
     * 获取client token
     * @return
     * @throws Exception
     */
    String getClientToken() throws Exception;
}
