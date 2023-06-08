package io.github.fengwensheng100.core.service;

import io.github.fengwensheng100.data.service.*;
import io.github.fengwensheng100.life.service.*;

public interface DouYinService {

    DouYinLifeCouponLedgerService getDouYinCouponLedgerService();

    DouYinLifeCouponService getDouYinCouponService();

    DouYinLifeMemberService getDouYinMemberService();

    DouYinLifeShopService getDouYinShopService();

    DouYinLifeAfterSaleService getDouYinAfterSaleService();

    DouYinDataBillBoardService getDouYinDataBillBoardService();

    DouYinDataDiscoveryService getDouYinDataDiscoveryService();

    DouYinDataFansService getDouYinDataFansService();

    DouYinDataHotSearchService getDouYinDataHotSearchService();

    DouYinDataItemService getDouYinDataItemService();

    DouYinDataStarService getDouYinDataStarService();

    DouYinDataUserService getDouYinDataUserService();

    Object getService(String name);

    /**
     * 抖音获取授权码
     * @return
     * @throws Exception
     */
    String getOauthConnect() throws Exception;

    /**
     * 获取access token
     * @return
     * @throws Exception
     */
    String getAccessToken() throws Exception;

    /**
     * 获取client token
     * @return
     * @throws Exception
     */
    String getClientToken() throws Exception;
}
