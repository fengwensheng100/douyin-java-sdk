package douyin.life.service;

import douyin.life.req.MemberUpdateReq;
import douyin.life.resp.BaseResp;
import douyin.life.resp.MemberUpdateResp;

public interface DouYinMemberService {

    /**
     * 会员数据更新，更新抖音用户的积分/等级
     * @return
     */
    BaseResp<MemberUpdateResp> memberUpdate(MemberUpdateReq memberUpdateReq);

    /**
     * 本地生活用户/会员获取电商侧会员的unionId
     * @return
     */
    String memberUnionIdGet();
}
