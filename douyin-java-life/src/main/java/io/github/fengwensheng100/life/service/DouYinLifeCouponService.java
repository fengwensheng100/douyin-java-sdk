package io.github.fengwensheng100.life.service;

import io.github.fengwensheng100.common.resp.BaseResp;
import io.github.fengwensheng100.life.req.CertificateCancelReq;
import io.github.fengwensheng100.life.req.CertificateQueryReq;
import io.github.fengwensheng100.life.req.CertificateVerifyReq;
import io.github.fengwensheng100.life.resp.*;

public interface DouYinLifeCouponService {

    /**
     * 核销准备接口
     * @param short_url 短链接
     * @param token
     * @return
     */
    BaseResp<CertificatePrepareResp> certificatePrepare(String short_url, String token) throws Exception;

    /**
     * 核销准备接口
     * @param code 券码
     * @param token
     * @return
     * @throws Exception
     */
    BaseResp<CertificatePrepareResp> certificatePrepareByCode(String code, String token) throws Exception;

    /**
     * 券状态查询
     * @param encrypted_code 加密券码
     * @param token
     * @return
     * @throws Exception
     */
    BaseResp<CertificateGetResp> certificateGet(String encrypted_code, String token) throws Exception;

    /**
     * 券状态批量查询
     * @param certificateQueryReq 券状态批量查询请求
     * @param token
     * @return
     * @throws Exception
     */
    BaseResp<CertificateQueryResp> certificateQuery(CertificateQueryReq certificateQueryReq, String token) throws Exception;

    /**
     * 验券
     * @param certificateVerifyReq 验券请求
     * @param token
     * @return
     * @throws Exception
     */
    BaseResp<CertificateVerifyResp> certificateVerify(CertificateVerifyReq certificateVerifyReq, String token) throws Exception;

    /**
     * 撤销核销
     * @param certificateCancelReq 撤销核销请求
     * @param token
     * @return
     * @throws Exception
     */
    BaseResp<CertificateCancelResp> certificateCancel(CertificateCancelReq certificateCancelReq, String token) throws Exception;
}
