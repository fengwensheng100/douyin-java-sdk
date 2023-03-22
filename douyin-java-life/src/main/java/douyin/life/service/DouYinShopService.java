package douyin.life.service;

import douyin.life.req.ShopPoiQueryReq;
import douyin.life.resp.BaseResp;
import douyin.life.resp.PoiMatchRelationQuery;
import douyin.life.resp.ShopPoiQueryResp;

import java.util.List;

public interface DouYinShopService {

    /**
     * 门店信息查询
     * @param shopPoiQueryReq 门店信息查询请求
     * @param token
     * @return
     * @throws Exception
     */
    BaseResp<ShopPoiQueryResp> shopPoiQuery(ShopPoiQueryReq shopPoiQueryReq, String token) throws Exception;

    /**
     * 门店信息更新
     * @param third_id
     * @return
     */
    void shopPoiUpdate(String poi_id, String third_id);

    /**
     * 查询匹配关系
     * @param third_id 第三方门店id列表
     * @param token
     * @return
     * @throws Exception
     */
    BaseResp<PoiMatchRelationQuery> poiMatchRelationQuery(List<String> third_id, String token) throws Exception;
}
