package io.github.feng.life.req;

import lombok.Data;
import java.util.List;

/**
 * @ClassName MemberUpdateReq
 * @Description: 会员数据更新请求体
 * @Author fengwensheng
 * @Date 2022/10/19
 * @Version V1.0
 **/
@Data
public class MemberUpdateReq {

    /**
     * 商户id，是否必填：是
     */
    private String account_id;
    /**
     * 批量积分等级变更，是否必填：是
     */
    private List<Member> members;
    @Data
    public static class Member {
        /**
         * 用户/会员openId，是否必填：是
         */
        private String open_id;
        /**
         * 积分更新数量（积分数*100），若不传则对应的该条积分流水不会展示
         */
        private int points_update_cent;
        /**
         * 用户最新积分(积分数量 * 100)，是否必填：是
         */
        private int points_amount_cent;
        /**
         * 新的等级，是否必填：是
         */
        private int user_level;
        /**
         * 数据更新时间（秒时间戳），是否必填：是
         */
        private long update_time;
    }
}
