package douyin.life.service;

import douyin.life.req.CertificateCancelReq;
import douyin.life.req.CertificateQueryReq;
import douyin.life.req.CertificateVerifyReq;
import douyin.life.resp.*;

public interface DouYinCouponService {

    /**
     * 核销准备接口
     * @param shortUrl 短链接
     * @return
     */
    BaseResp<CertificatePrepareResp> certificatePrepare(String shortUrl, String token) throws Exception;


    /**
     * 核销准备接口
     * @param code
     * @return
     */
    BaseResp<CertificatePrepareResp> certificatePrepareByCode(String code, String token) throws Exception;

    /**
     * 券状态查询
     * @param encrypted_code
     * @return
     */
    BaseResp<CertificateGetResp> certificateGet(String encrypted_code, String token) throws Exception;

    /**
     * 券状态批量查询
     * @param certificateQueryReq
     * @param token
     * @return
     * @throws Exception
     */
    BaseResp<CertificateQueryResp> certificateQuery(CertificateQueryReq certificateQueryReq, String token) throws Exception;

    /**
     * @Title: 核销
     * @Description:
     * @author fengwensheng
     * @date 2022/10/23 0:25
     */
    BaseResp<CertificateVerifyResp> certificateVerify(CertificateVerifyReq certificateVerifyReq, String token) throws Exception;

    /**
     * 撤销核销
     * @param certificateCancelReq
     * @param token
     * @return
     * @throws Exception
     */
    BaseResp<CertificateCancelResp> certificateCancel(CertificateCancelReq certificateCancelReq, String token) throws Exception;

    /**
     * 缓存获取抖音token
     * @return
     * @throws Exception
     */
    String getDouYinToken() throws Exception;
}
