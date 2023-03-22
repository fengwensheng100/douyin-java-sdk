package com.github.feng.life.life.service;

import com.github.feng.life.life.req.MemberUpdateReq;
import com.github.feng.life.life.resp.BaseResp;
import com.github.feng.life.life.resp.MemberUpdateResp;

public interface DouYinMemberService {

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