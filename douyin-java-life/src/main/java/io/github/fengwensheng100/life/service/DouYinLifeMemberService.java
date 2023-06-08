package io.github.fengwensheng100.life.service;

import io.github.fengwensheng100.common.resp.BaseResp;
import io.github.fengwensheng100.life.req.MemberUpdateReq;
import io.github.fengwensheng100.life.resp.MemberUpdateResp;

public interface DouYinLifeMemberService {

    /**
     * 会员数据更新，更新抖音用户的积分/等级
     * @param memberUpdateReq 会员数据更新请求体
     * @param token
     * @return
     * @throws Exception
     */
    BaseResp<MemberUpdateResp> memberUpdate(MemberUpdateReq memberUpdateReq, String token) throws Exception;

    /**
     * 本地生活用户/会员获取电商侧会员的unionId
     * @return
     */
    String memberUnionIdGet();
}
