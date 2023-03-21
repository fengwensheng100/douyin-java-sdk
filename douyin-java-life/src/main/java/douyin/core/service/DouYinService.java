package douyin.core.service;

import douyin.common.config.DouYinConfig;
import douyin.core.common.ServiceContainer;
import douyin.life.service.*;
import douyin.life.service.impl.*;

public class DouYinService {
    public static DouYinConfig config;
    private static String DOUYIN_COUPON_LEDGER_SERVICE = "douYinCouponLedgerService";
    private static String DOUYIN_COUPON_SERVICE = "douYinCouponService";
    private static String DOUYIN_LIFE_SERVICE = "douYinLifeService";
    private static String DOUYIN_MEMBER_SERVICE = "douYinMemberService";
    private static String DOUYIN_SHOP_SERVICE = "douYinShopService";
    private static String DOUYIN_AFTER_SALE_SERVICE = "douYinAfterSaleService";
    private final static DouYinCouponLedgerService douYinCouponLedgerService = new DouYinCouponLedgerServiceImpl();
    private final static DouYinCouponService douYinCouponService = new DouYinCouponServiceImpl();
    private final static DouYinLifeService douYinLifeService = new DouYinLifeServiceImpl();
    private final static DouYinMemberService douYinMemberService = new DouYinMemberServiceImpl();
    private final static DouYinShopService douYinShopService = new DouYinShopServiceImpl();
    private final static DouYinAfterSaleService douYinAfterSaleService = new DouYinAfterSaleServiceImpl();
    public DouYinService(DouYinConfig config) {
        this.config = config;
        ServiceContainer.registerService(DOUYIN_COUPON_LEDGER_SERVICE, douYinCouponLedgerService);
        ServiceContainer.registerService(DOUYIN_COUPON_SERVICE, douYinCouponService);
        ServiceContainer.registerService(DOUYIN_LIFE_SERVICE, douYinLifeService);
        ServiceContainer.registerService(DOUYIN_MEMBER_SERVICE, douYinMemberService);
        ServiceContainer.registerService(DOUYIN_SHOP_SERVICE, douYinShopService);
        ServiceContainer.registerService(DOUYIN_AFTER_SALE_SERVICE, douYinAfterSaleService);
    }

    public static DouYinConfig getConfig() throws Exception {
        if (config == null) {
            throw new Exception("抖音配置文件未配置");
        }
        return config;
    }

    public DouYinCouponLedgerService getDouYinCouponLedgerService() {
        return (DouYinCouponLedgerService) ServiceContainer.getService(DOUYIN_COUPON_LEDGER_SERVICE);
    }

    public DouYinCouponService getDouYinCouponService() {
        return (DouYinCouponService) ServiceContainer.getService(DOUYIN_COUPON_SERVICE);
    }

    public DouYinLifeService getDouYinLifeService() {
        return (DouYinLifeService) ServiceContainer.getService(DOUYIN_LIFE_SERVICE);
    }

    public DouYinMemberService getDouYinMemberService() {
        return (DouYinMemberService) ServiceContainer.getService(DOUYIN_MEMBER_SERVICE);
    }

    public DouYinShopService getDouYinShopService() {
        return (DouYinShopService) ServiceContainer.getService(DOUYIN_SHOP_SERVICE);
    }

    public DouYinAfterSaleService getDouYinAfterSaleService() {
        return (DouYinAfterSaleService) ServiceContainer.getService(DOUYIN_AFTER_SALE_SERVICE);
    }

    public Object getService(String name) {
        return ServiceContainer.getService(name);
    }
}
