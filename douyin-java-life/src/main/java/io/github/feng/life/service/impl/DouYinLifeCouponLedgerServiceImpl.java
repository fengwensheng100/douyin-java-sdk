package io.github.feng.life.service.impl;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import io.github.feng.common.constant.DouYinLifeConstant;
import io.github.feng.common.resp.BaseResp;
import io.github.feng.common.util.DouYinHttpUtils;
import io.github.feng.common.util.HttpUtils;
import io.github.feng.life.req.LedgerDetailedQueryReq;
import io.github.feng.life.req.VerifyRecordQueryReq;
import io.github.feng.life.resp.CertificateBillQueryResp;
import io.github.feng.life.resp.LedgerDetailedQueryResp;
import io.github.feng.life.service.DouYinLifeCouponLedgerService;
import org.apache.commons.lang3.StringUtils;
import java.util.Map;

public class DouYinLifeCouponLedgerServiceImpl implements DouYinLifeCouponLedgerService {

    public BaseResp<CertificateBillQueryResp> verifyRecordQuery(VerifyRecordQueryReq verifyRecordQueryReq, String token) throws Exception {
        if (verifyRecordQueryReq.getSize() == 0) {
            verifyRecordQueryReq.setSize(20);
        }
        if (StringUtils.isBlank(verifyRecordQueryReq.getCursor())) {
            verifyRecordQueryReq.setCursor("0");
        }
        if (StringUtils.isBlank(verifyRecordQueryReq.getAccount_id())) {
            throw new Exception("企业号商家总店id不能为空");
        }
        String urlParams = DouYinHttpUtils.mapToUrlParams(JSONUtil.toBean(JSONUtil.toJsonStr(verifyRecordQueryReq), Map.class));
        String result = DouYinHttpUtils.get(DouYinLifeConstant.VERIFY_RECORD_QUERY + "?" + urlParams, null, HttpUtils.APPLICATION_JSON, token);
        BaseResp<CertificateBillQueryResp> certificateBillQueryResp = JSONUtil.toBean(result, new TypeReference<BaseResp<CertificateBillQueryResp>>(){}, false);
        return certificateBillQueryResp;
    }

    public BaseResp<LedgerDetailedQueryResp> detailedQuery(LedgerDetailedQueryReq ledgerDetailedQueryReq, String token) throws Exception {
        if (ledgerDetailedQueryReq.getSize() == 0) {
            ledgerDetailedQueryReq.setSize(50);
        }
        if (StringUtils.isBlank(ledgerDetailedQueryReq.getCursor())) {
            ledgerDetailedQueryReq.setCursor("0");
        }
        if (StringUtils.isBlank(ledgerDetailedQueryReq.getAccount_id())) {
            throw new Exception("企业号商家总店id不能为空");
        }
        if (StringUtils.isBlank(ledgerDetailedQueryReq.getBill_date())) {
            throw new Exception("核销日期不能为空");
        }
        String urlParams = DouYinHttpUtils.mapToUrlParams(JSONUtil.toBean(JSONUtil.toJsonStr(ledgerDetailedQueryReq), Map.class));
        String result = DouYinHttpUtils.get(DouYinLifeConstant.DETAILED_QUERY + "?" + urlParams, null, HttpUtils.APPLICATION_JSON, token);
        BaseResp<LedgerDetailedQueryResp> ledgerDetailedQueryRespBaseResp = JSONUtil.toBean(result, new TypeReference<BaseResp<LedgerDetailedQueryResp>>(){}, false);
        return ledgerDetailedQueryRespBaseResp;
    }
}
