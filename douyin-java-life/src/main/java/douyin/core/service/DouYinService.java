package douyin.core.service;

import douyin.common.config.DouYinConfig;
import douyin.core.common.ServiceContainer;
import douyin.life.service.*;
import douyin.life.service.impl.*;

public class DouYinService {

    public static DouYinConfig config;

    public DouYinService(DouYinConfig config) {
        this.config = config;
    }

    public static DouYinConfig getConfig() throws Exception {
        if (config == null) {
            throw new Exception("抖音配置文件未配置");
        }
        return config;
    }

    public DouYinCouponLedgerService getDouYinCouponLedgerService() {
        String serviceName = "douYinCouponLedgerService";
        if (ServiceContainer.getService(serviceName) == null) {
            DouYinCouponLedgerService douYinCouponLedgerService = new DouYinCouponLedgerServiceImpl();
            ServiceContainer.registerService(serviceName, douYinCouponLedgerService);
        }
        return (DouYinCouponLedgerService) ServiceContainer.getService(serviceName);
    }

    public DouYinCouponService getDouYinCouponService() {
        String serviceName = "douYinCouponService";
        if (ServiceContainer.getService(serviceName) == null) {
            DouYinCouponService douYinCouponService = new DouYinCouponServiceImpl();
            ServiceContainer.registerService(serviceName, douYinCouponService);
        }
        return (DouYinCouponService) ServiceContainer.getService(serviceName);
    }

    public DouYinLifeService getDouYinLifeService() {
        String serviceName = "douYinLifeService";
        if (ServiceContainer.getService(serviceName) == null) {
            DouYinLifeService douYinLifeService = new DouYinLifeServiceImpl();
            ServiceContainer.registerService(serviceName, douYinLifeService);
        }
        return (DouYinLifeService) ServiceContainer.getService(serviceName);
    }

    public DouYinMemberService getDouYinMemberService() {
        String serviceName = "douYinMemberService";
        if (ServiceContainer.getService(serviceName) == null) {
            DouYinMemberService douYinMemberService = new DouYinMemberServiceImpl();
            ServiceContainer.registerService(serviceName, douYinMemberService);
        }
        return (DouYinMemberService) ServiceContainer.getService(serviceName);
    }

    public DouYinShopService getDouYinShopService() {
        String serviceName = "douYinShopService";
        if (ServiceContainer.getService(serviceName) == null) {
            DouYinShopService douYinShopService = new DouYinShopServiceImpl();
            ServiceContainer.registerService(serviceName, douYinShopService);
        }
        return (DouYinShopService) ServiceContainer.getService(serviceName);
    }

    public Object getService(String name) {
        return ServiceContainer.getService(name);
    }
}
