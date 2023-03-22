package douyin.core.service.impl;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import douyin.common.config.DouYinConfig;
import douyin.common.constant.DouYinLifeConstant;
import douyin.common.util.HttpUtils;
import douyin.core.common.ServiceContainer;
import douyin.core.service.DouYinService;
import douyin.life.resp.AccessTokenResp;
import douyin.life.resp.BaseResp;
import douyin.life.service.*;
import douyin.life.service.impl.*;
import java.util.HashMap;
import java.util.Map;

public class DouYinServiceImpl implements DouYinService {

    public static DouYinConfig config;
    private static String DOUYIN_COUPON_LEDGER_SERVICE = "douYinCouponLedgerService";
    private static String DOUYIN_COUPON_SERVICE = "douYinCouponService";
    private static String DOUYIN_MEMBER_SERVICE = "douYinMemberService";
    private static String DOUYIN_SHOP_SERVICE = "douYinShopService";
    private static String DOUYIN_AFTER_SALE_SERVICE = "douYinAfterSaleService";
    private final static DouYinCouponLedgerService douYinCouponLedgerService = new DouYinCouponLedgerServiceImpl();
    private final static DouYinCouponService douYinCouponService = new DouYinCouponServiceImpl();
    private final static DouYinMemberService douYinMemberService = new DouYinMemberServiceImpl();
    private final static DouYinShopService douYinShopService = new DouYinShopServiceImpl();
    private final static DouYinAfterSaleService douYinAfterSaleService = new DouYinAfterSaleServiceImpl();
    public DouYinServiceImpl(DouYinConfig config) {
        this.config = config;
        ServiceContainer.registerService(DOUYIN_COUPON_LEDGER_SERVICE, douYinCouponLedgerService);
        ServiceContainer.registerService(DOUYIN_COUPON_SERVICE, douYinCouponService);
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
