package douyin.life.service.impl;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import douyin.common.constant.DouYinLifeConstant;
import douyin.common.util.HttpUtils;
import douyin.core.service.DouYinService;
import douyin.life.resp.AccessTokenResp;
import douyin.life.resp.BaseResp;
import douyin.life.service.DouYinLifeService;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DouYinLifeServiceImpl
 * @Description: TODO
 * @Author fengwensheng
 * @Date 2023/3/20
 * @Version V1.0
 **/
public class DouYinLifeServiceImpl implements DouYinLifeService {

    @Override
    public String getDouYinToken() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("client_key", DouYinService.getConfig().getClientKey());
        param.put("client_secret", DouYinService.getConfig().getClientSecret());
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
