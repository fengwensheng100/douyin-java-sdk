package douyin.life.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import douyin.common.constant.DouYinLifeConstant;
import douyin.common.util.DouYinHttpUtils;
import douyin.common.util.HttpUtils;
import douyin.life.req.MemberUpdateReq;
import douyin.life.resp.BaseResp;
import douyin.life.resp.MemberUpdateResp;
import douyin.life.service.DouYinMemberService;
import org.apache.commons.lang3.StringUtils;

public class DouYinMemberServiceImpl implements DouYinMemberService {

    public BaseResp<MemberUpdateResp> memberUpdate(MemberUpdateReq memberUpdateReq, String token) throws Exception {
        if (StringUtils.isBlank(memberUpdateReq.getAccount_id())) {
            throw new Exception("企业号商家总店id不能为空");
        }
        if (CollectionUtil.isEmpty(memberUpdateReq.getMembers())) {
            throw new Exception("更新的会员信息Members不能为空");
        }
        String result = DouYinHttpUtils.get(DouYinLifeConstant.MEMBER_UPDATE, null, HttpUtils.APPLICATION_JSON, token);
        BaseResp<MemberUpdateResp> memberUpdateRespBaseResp = JSONUtil.toBean(result, new TypeReference<BaseResp<MemberUpdateResp>>(){}, false);
        return memberUpdateRespBaseResp;
    }

    public String memberUnionIdGet() {
        return null;
    }
}
