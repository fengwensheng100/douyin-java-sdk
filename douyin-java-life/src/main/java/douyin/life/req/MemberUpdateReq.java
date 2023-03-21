package douyin.life.req;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @ClassName CertificatePrepareResp
 * @Description: 验券请求
 * @Author fengwensheng
 * @Date 2022/10/19
 * @Version V1.0
 **/
@Data
@Builder
public class MemberUpdateReq {

    /**
     * 商户id
     */
    private String account_id;
    /**
     * 批量积分等级变更
     */
    private List<Member> members;
    @Data
    @Builder
    public static class Member {
        /**
         * 用户/会员openId
         */
        private String open_id;
        /**
         * 积分更新数量（积分数*100），若不传则对应的该条积分流水不会展示
         */
        private int points_update_cent;
        /**
         * 用户最新积分(积分数量 * 100)
         */
        private int points_amount_cent;
        /**
         * 新的等级
         */
        private int user_level;
        /**
         * 数据更新时间（秒时间戳）
         */
        private long update_time;
    }
}
