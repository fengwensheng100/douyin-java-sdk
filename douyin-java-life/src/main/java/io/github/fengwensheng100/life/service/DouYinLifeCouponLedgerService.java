package io.github.fengwensheng100.life.service;

import io.github.fengwensheng100.common.resp.BaseResp;
import io.github.fengwensheng100.life.req.LedgerDetailedQueryReq;
import io.github.fengwensheng100.life.req.VerifyRecordQueryReq;
import io.github.fengwensheng100.life.resp.LedgerDetailedQueryResp;
import io.github.fengwensheng100.life.resp.CertificateBillQueryResp;

public interface DouYinLifeCouponLedgerService {

    /**
     * 验券历史查询
     * @param verifyRecordQueryReq 验券历史查询请求
     * @param token
     * @return
     * @throws Exception
     */
    BaseResp<CertificateBillQueryResp> verifyRecordQuery(VerifyRecordQueryReq verifyRecordQueryReq, String token) throws Exception;

    /**
     * 账单详细查询
     * @param ledgerDetailedQueryReq 账单详细查询请求
     * @param token
     * @return
     * @throws Exception
     */
    BaseResp<LedgerDetailedQueryResp> detailedQuery(LedgerDetailedQueryReq ledgerDetailedQueryReq, String token) throws Exception;
}
