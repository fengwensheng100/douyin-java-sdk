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
public class CertificateVerifyReq {
    /**
     * 一次验券的标识 (用于短时间内的幂等)，是否必填：是
     */
    private String verify_token;
    /**
     * 核销的抖音门店id，是否必填：是
     */
    private String poi_id;
    /**
     * 验券准备接口返回的加密抖音券码
     */
    private List<String> encrypted_codes;
    /**
     * 三方原始券码值列表 (encrypted_codes/codes/code_with_time_list必须三选一)
     * 多次卡商品，如果需要一次核销多份，list中传多个
     */
    private List<String> codes;
    /**
     * 带有核销时间的三方码列表
     * （如果code_with_time_list 和 codes 同时传， 本字段优先级更高）
     */
    private List<CodeWithTimeList> code_with_time_list;
    @Data
    public class CodeWithTimeList {
        /**
         * 三方码
         */
        private String code;
        /**
         * 核销时间戳（秒）
         */
        private long verify_time;
        /**
         * 验签
         */
        private List<String> verify_sign_list;
    }
    /**
     * 多项目多凭证的情况
     * 备注：景区预售券核销必传，非景点预售券核销可忽略！
     */
    private Voucher voucher;
    @Data
    public class Voucher {
        /**
         * 项目唯一标识（景区预售券必传）
         */
        private String project_id;
        /**
         * 身份证号码
         */
        private List<String> id_card_list;
        /**
         * 二维码
         */
        private List<String> qrcode_list;
        /**
         * 券号
         */
        private List<String> certificate_no_list;
        /**
         * 核销时间戳（秒）（景区预售券必传）
         */
        private long verify_time;
    }
}
