package douyin.life.service;

import douyin.life.req.LedgerDetailedQueryReq;
import douyin.life.req.VerifyRecordQueryReq;
import douyin.life.resp.BaseResp;
import douyin.life.resp.CertificateBillQueryResp;
import douyin.life.resp.LedgerDetailedQueryResp;

public interface DouYinCouponLedgerService {

    /**
     * 验券记录
     * @param verifyRecordQueryReq
     * @return
     */
    BaseResp<CertificateBillQueryResp> verifyRecordQuery(VerifyRecordQueryReq verifyRecordQueryReq, String token) throws Exception;

    /**
     * 账单详细查询
     * @param ledgerDetailedQueryReq
     * @param token
     * @return
     * @throws Exception
     */
    BaseResp<LedgerDetailedQueryResp> detailedQuery(LedgerDetailedQueryReq ledgerDetailedQueryReq, String token) throws Exception;
}
