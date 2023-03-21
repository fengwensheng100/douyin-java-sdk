package douyin.life.service;

import douyin.life.req.ShopPoiQueryReq;
import douyin.life.resp.BaseResp;
import douyin.life.resp.ShopPoiQueryResp;

public interface DouYinShopService {

    /**
     * @Title: 门店信息查询
     * @Description:
     * @author fengwensheng
     * @date 2022/10/23 1:25
     */
    BaseResp<ShopPoiQueryResp> shopPoiQuery(ShopPoiQueryReq shopPoiQueryReq, String token) throws Exception;

    /**
     * 关联抖音门店
     * @param third_id
     * @return
     */
    void shopPoiUpdate(String poi_id, String third_id);
}
