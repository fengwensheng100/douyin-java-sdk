package douyin.core.service;

import douyin.life.service.*;

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
