package douyin.life.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import douyin.common.constant.DouYinLifeConstant;
import douyin.common.util.DouYinHttpUtils;
import douyin.common.util.HttpUtils;
import douyin.life.req.ShopPoiQueryReq;
import douyin.life.resp.BaseResp;
import douyin.life.resp.PoiMatchRelationQuery;
import douyin.life.resp.ShopPoiQueryResp;
import douyin.life.service.DouYinShopService;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DouYinShopServiceImpl implements DouYinShopService {

    public BaseResp<ShopPoiQueryResp> shopPoiQuery(ShopPoiQueryReq shopPoiQueryReq, String token) throws Exception {
        if (shopPoiQueryReq.getSize() == 0) {
            shopPoiQueryReq.setSize(20);
        }
        if (shopPoiQueryReq.getPage() == 0) {
            shopPoiQueryReq.setPage(1);
        }
        if (StringUtils.isBlank(shopPoiQueryReq.getAccount_id()) && StringUtils.isBlank(shopPoiQueryReq.getPoi_id()) && StringUtils.isBlank(shopPoiQueryReq.getThird_id())) {
            throw new Exception("[account_id,third_id,poi_id]必须选择一个进行查询");
        }
        String urlParams = DouYinHttpUtils.mapToUrlParams(JSONUtil.toBean(JSONUtil.toJsonStr(shopPoiQueryReq), Map.class));
        String result = DouYinHttpUtils.get(DouYinLifeConstant.SHOP_POI_QUERY + "?" + urlParams, null, HttpUtils.APPLICATION_JSON, token);
        BaseResp<ShopPoiQueryResp> shopPoiQueryRespBaseResp = JSONUtil.toBean(result, new TypeReference<BaseResp<ShopPoiQueryResp>>(){}, false);
        return shopPoiQueryRespBaseResp;
    }

    public void shopPoiUpdate(String poi_id, String third_id) {
    }

    @Override
    public BaseResp<PoiMatchRelationQuery> poiMatchRelationQuery(List<String> thirdId, String token) throws Exception {
        if (CollectionUtil.isEmpty(thirdId)) {
            throw new Exception("第三方门店id列表不能为空");
        }
        String urlParams = thirdId.stream().map(String::valueOf).collect(Collectors.joining(","));
        String result = DouYinHttpUtils.get(DouYinLifeConstant.POI_MATCH_RELATION_QUERY + "?ext_ids=" + urlParams, null, HttpUtils.APPLICATION_JSON, token);
        BaseResp<PoiMatchRelationQuery> poiMatchRelationQueryBaseResp = JSONUtil.toBean(result, new TypeReference<BaseResp<PoiMatchRelationQuery>>(){}, false);
        return poiMatchRelationQueryBaseResp;
    }
}
