package com.github.feng.core.service.impl;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.github.feng.common.config.DouYinConfig;
import com.github.feng.common.constant.DouYinLifeConstant;
import com.github.feng.common.resp.AccessTokenResp;
import com.github.feng.common.resp.BaseResp;
import com.github.feng.common.util.HttpUtils;
import com.github.feng.core.common.ServiceContainer;
import com.github.feng.core.service.DouYinService;
import com.github.feng.data.service.*;
import com.github.feng.data.service.impl.*;
import com.github.feng.life.life.service.*;
import com.github.feng.life.life.service.impl.*;
import java.util.HashMap;
import java.util.Map;

public class DouYinServiceImpl implements DouYinService {

    public static DouYinConfig config;
    //life
    private static String DOUYIN_LIFE_COUPON_LEDGER_SERVICE = "douYinLifeCouponLedgerService";
    private static String DOUYIN_LIFE_COUPON_SERVICE = "douYinLifeCouponService";
    private static String DOUYIN_LIFE_MEMBER_SERVICE = "douYinLifeMemberService";
    private static String DOUYIN_LIFE_SHOP_SERVICE = "douYinLifeShopService";
    private static String DOUYIN_LIFE_AFTER_SALE_SERVICE = "douYinLifeAfterSaleService";
    private final static DouYinLifeCouponLedgerService douYinCouponLedgerService = new DouYinLifeCouponLedgerServiceImpl();
    private final static DouYinLifeCouponService douYinCouponService = new DouYinLifeCouponServiceImpl();
    private final static DouYinLifeMemberService douYinMemberService = new DouYinLifeMemberServiceImpl();
    private final static DouYinLifeShopService douYinShopService = new DouYinLifeShopServiceImpl();
    private final static DouYinLifeAfterSaleService douYinAfterSaleService = new DouYinLifeAfterSaleServiceImpl();
    //data
    private static String DOU_YIN_DATA_BILL_BOARD_SERVICE = "douYinDataBillBoardService";
    private static String DOU_YIN_DATA_DISCOVERY_SERVICE = "douYinDataDiscoveryService";
    private static String DOU_YIN_DATA_FANS_SERVICE = "douYinDataFansService";
    private static String DOU_YIN_DATA_HOT_SEARCH_SERVICE = "douYinDataHotSearchService";
    private static String DOU_YIN_DATA_ITEM_SERVICE = "douYinDataItemService";
    private static String DOU_YIN_DATA_STAR_SERVICE = "douYinDataStarService";
    private static String DOU_YIN_DATA_USER_SERVICE = "douYinDataUserService";
    private final static DouYinDataBillBoardService douYinDataBillBoardService = new DouYinDataBillBoardServiceImpl();
    private final static DouYinDataDiscoveryService douYinDataDiscoveryService = new DouYinDataDiscoveryServiceImpl();
    private final static DouYinDataFansService douYinDataFansService = new DouYinDataFansServiceImpl();
    private final static DouYinDataHotSearchService douYinDataHotSearchService = new DouYinDataHotSearchServiceImpl();
    private final static DouYinDataItemService douYinDataItemService = new DouYinDataItemServiceImpl();
    private final static DouYinDataStarService douYinDataStarService = new DouYinDataStarServiceImpl();
    private final static DouYinDataUserService douYinDataUserService = new DouYinDataUserServiceImpl();
    public DouYinServiceImpl(DouYinConfig config) {
        this.config = config;
        //life
        ServiceContainer.registerService(DOUYIN_LIFE_COUPON_LEDGER_SERVICE, douYinCouponLedgerService);
        ServiceContainer.registerService(DOUYIN_LIFE_COUPON_SERVICE, douYinCouponService);
        ServiceContainer.registerService(DOUYIN_LIFE_MEMBER_SERVICE, douYinMemberService);
        ServiceContainer.registerService(DOUYIN_LIFE_SHOP_SERVICE, douYinShopService);
        ServiceContainer.registerService(DOUYIN_LIFE_AFTER_SALE_SERVICE, douYinAfterSaleService);
        //data
        ServiceContainer.registerService(DOU_YIN_DATA_BILL_BOARD_SERVICE, douYinDataBillBoardService);
        ServiceContainer.registerService(DOU_YIN_DATA_DISCOVERY_SERVICE, douYinDataDiscoveryService);
        ServiceContainer.registerService(DOU_YIN_DATA_FANS_SERVICE, douYinDataFansService);
        ServiceContainer.registerService(DOU_YIN_DATA_HOT_SEARCH_SERVICE, douYinDataHotSearchService);
        ServiceContainer.registerService(DOU_YIN_DATA_ITEM_SERVICE, douYinDataItemService);
        ServiceContainer.registerService(DOU_YIN_DATA_STAR_SERVICE, douYinDataStarService);
        ServiceContainer.registerService(DOU_YIN_DATA_USER_SERVICE, douYinDataUserService);
    }

    public static DouYinConfig getConfig() throws Exception {
        if (config == null) {
            throw new Exception("抖音配置文件未配置");
        }
        return config;
    }

    @Override
    public DouYinLifeCouponLedgerService getDouYinCouponLedgerService() {
        return (DouYinLifeCouponLedgerService) ServiceContainer.getService(DOUYIN_LIFE_COUPON_LEDGER_SERVICE);
    }

    @Override
    public DouYinLifeCouponService getDouYinCouponService() {
        return (DouYinLifeCouponService) ServiceContainer.getService(DOUYIN_LIFE_COUPON_SERVICE);
    }

    @Override
    public DouYinLifeMemberService getDouYinMemberService() {
        return (DouYinLifeMemberService) ServiceContainer.getService(DOUYIN_LIFE_MEMBER_SERVICE);
    }

    @Override
    public DouYinLifeShopService getDouYinShopService() {
        return (DouYinLifeShopService) ServiceContainer.getService(DOUYIN_LIFE_SHOP_SERVICE);
    }

    @Override
    public DouYinLifeAfterSaleService getDouYinAfterSaleService() {
        return (DouYinLifeAfterSaleService) ServiceContainer.getService(DOUYIN_LIFE_AFTER_SALE_SERVICE);
    }

    @Override
    public DouYinDataBillBoardService getDouYinDataBillBoardService() {
        return (DouYinDataBillBoardService) ServiceContainer.getService(DOU_YIN_DATA_BILL_BOARD_SERVICE);
    }

    @Override
    public DouYinDataDiscoveryService getDouYinDataDiscoveryService() {
        return (DouYinDataDiscoveryService) ServiceContainer.getService(DOU_YIN_DATA_DISCOVERY_SERVICE);
    }

    @Override
    public DouYinDataFansService getDouYinDataFansService() {
        return (DouYinDataFansService) ServiceContainer.getService(DOU_YIN_DATA_FANS_SERVICE);
    }

    @Override
    public DouYinDataHotSearchService getDouYinDataHotSearchService() {
        return (DouYinDataHotSearchService) ServiceContainer.getService(DOU_YIN_DATA_HOT_SEARCH_SERVICE);
    }

    @Override
    public DouYinDataItemService getDouYinDataItemService() {
        return (DouYinDataItemService) ServiceContainer.getService(DOU_YIN_DATA_ITEM_SERVICE);
    }

    @Override
    public DouYinDataStarService getDouYinDataStarService() {
        return (DouYinDataStarService) ServiceContainer.getService(DOU_YIN_DATA_STAR_SERVICE);
    }

    @Override
    public DouYinDataUserService getDouYinDataUserService() {
        return (DouYinDataUserService) ServiceContainer.getService(DOU_YIN_DATA_USER_SERVICE);
    }

    public Object getService(String name) {
        return ServiceContainer.getService(name);
    }

    @Override
    public String getClientToken() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("client_key", getConfig().getClientKey());
        param.put("client_secret", getConfig().getClientSecret());
        param.put("grant_type", "client_credential");
        String params = HttpUtils.mapToUrlParams(param);

        String result = HttpUtils.post(DouYinLifeConstant.CLIENT_TOKEN, params, HttpUtils.APPLICATION_X_WWW_FORM_URLENCODED);

        BaseResp<AccessTokenResp> prepareRespBaseResp = JSONUtil.toBean(result, new TypeReference<BaseResp<AccessTokenResp>>(){}, false);
        if (prepareRespBaseResp.getData().getError_code() == 0) {
            return prepareRespBaseResp.getData().getAccess_token();
        }
        return null;
    }
}
