package douyin.life.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import douyin.common.constant.DouYinLifeConstant;
import douyin.common.util.DouYinHttpUtils;
import douyin.common.util.HttpUtils;
import douyin.core.service.DouYinService;
import douyin.life.req.CertificateCancelReq;
import douyin.life.req.CertificateQueryReq;
import douyin.life.req.CertificateVerifyReq;
import douyin.life.resp.*;
import douyin.life.service.DouYinCouponService;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName DouYinCouponServiceImpl
 * @Description: TODO
 * @Author fengwensheng
 * @Date 2023/3/15
 * @Version V1.0
 **/
public class DouYinCouponServiceImpl implements DouYinCouponService {

    public BaseResp<CertificatePrepareResp> certificatePrepare(String short_url, String token) throws Exception {
        String object_id = DouYinHttpUtils.getDouYinUrlParams(short_url, "object_id");
        String result = DouYinHttpUtils.get(DouYinLifeConstant.CERTIFICATE_PREPARE + "?encrypted_data=" + object_id, null, token);
        BaseResp<CertificatePrepareResp> prepareRespBaseResp = JSONUtil.toBean(result, new TypeReference<BaseResp<CertificatePrepareResp>>(){}, false);
        return prepareRespBaseResp;
    }

    public BaseResp<CertificatePrepareResp> certificatePrepareByCode(String code, String token) throws Exception {
        String result = DouYinHttpUtils.get(DouYinLifeConstant.CERTIFICATE_PREPARE + "?code=" + code, null, HttpUtils.APPLICATION_JSON, token);
        BaseResp<CertificatePrepareResp> prepareRespBaseResp = JSONUtil.toBean(result, new TypeReference<BaseResp<CertificatePrepareResp>>(){}, false);
        return prepareRespBaseResp;
    }

    public BaseResp<CertificateGetResp> certificateGet(String encrypted_code, String token) throws Exception {
        encrypted_code = encrypted_code.replace("/", "%2F").replace("+", "%2B");
        String result = DouYinHttpUtils.get(DouYinLifeConstant.CERTIFICATE_GET + "?encrypted_code=" + encrypted_code, null, HttpUtils.APPLICATION_JSON, token);
        BaseResp<CertificateGetResp> prepareRespBaseResp = JSONUtil.toBean(result, new TypeReference<BaseResp<CertificateGetResp>>(){}, false);
        return prepareRespBaseResp;
    }

    public BaseResp<CertificateQueryResp> certificateQuery(CertificateQueryReq certificateQueryReq, String token) throws Exception {
        if (StringUtils.isBlank(certificateQueryReq.getEncrypted_code()) && StringUtils.isBlank(certificateQueryReq.getOrder_id())) {
            throw new Exception("encrypted_code和order_id二者必传一个");
        }
        String result;
        if (StringUtils.isNotBlank(certificateQueryReq.getEncrypted_code())) {
            result = DouYinHttpUtils.get(DouYinLifeConstant.CERTIFICATE_QUERY + "?encrypted_code=" + certificateQueryReq.getEncrypted_code(), null, HttpUtils.APPLICATION_JSON, token);
        } else {
            result = DouYinHttpUtils.get(DouYinLifeConstant.CERTIFICATE_QUERY + "?order_id=" + certificateQueryReq.getOrder_id(), null, HttpUtils.APPLICATION_JSON, token);
        }
        BaseResp<CertificateQueryResp> certificateQueryResp = JSONUtil.toBean(result, new TypeReference<BaseResp<CertificateQueryResp>>() {}, false);
        return certificateQueryResp;
    }

    public BaseResp<CertificateVerifyResp> certificateVerify(CertificateVerifyReq certificateVerifyReq, String token) throws Exception {
        if (StringUtils.isBlank(certificateVerifyReq.getVerify_token())) {
            throw new Exception("验券标识不能为空");
        }
        if (StringUtils.isBlank(certificateVerifyReq.getPoi_id())) {
            throw new Exception("核销的抖音门店id不能为空");
        }
        if (CollectionUtil.isEmpty(certificateVerifyReq.getEncrypted_codes()) &&
                CollectionUtil.isEmpty(certificateVerifyReq.getCodes()) &&
                CollectionUtil.isEmpty(certificateVerifyReq.getCode_with_time_list())) {
            throw new Exception("encrypted_codes，codes，code_with_time_list参数必须三选一");
        }
        String result = DouYinHttpUtils.post(DouYinLifeConstant.CERTIFICATE_VERIFY, JSONUtil.toJsonStr(certificateVerifyReq), HttpUtils.APPLICATION_JSON, token);
        BaseResp<CertificateVerifyResp> verifyRespBaseResp = JSONUtil.toBean(result, new TypeReference<BaseResp<CertificateVerifyResp>>(){}, false);
        return verifyRespBaseResp;
    }

    public BaseResp<CertificateCancelResp> certificateCancel(CertificateCancelReq certificateCancelReq, String token) throws Exception {
        if (StringUtils.isBlank(certificateCancelReq.getVerify_id())) {
            throw new Exception("核销的唯一标识不能为空");
        }
        if (StringUtils.isBlank(certificateCancelReq.getCertificate_id())) {
            throw new Exception("券码的标识不能为空");
        }
        String result = DouYinHttpUtils.post(DouYinLifeConstant.CERTIFICATE_CANCEL, JSONUtil.toJsonStr(certificateCancelReq), HttpUtils.APPLICATION_JSON, token);
        BaseResp<CertificateCancelResp> certificateCancelResp = JSONUtil.toBean(result, new TypeReference<BaseResp<CertificateCancelResp>>(){}, false);
        return certificateCancelResp;
    }

    public String getDouYinToken() throws Exception {
        return null;
    }
}
