package douyin.life.req;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName CertificatePrepareResp
 * @Description: 验券请求
 * @Author fengwensheng
 * @Date 2022/10/19
 * @Version V1.0
 **/
@Data
@Builder
public class CertificateCancelReq {

    /**
     * 代表券码一次核销的唯一标识（验券时返回），是否必填：是
     */
    private String verify_id;
    /**
     * 代表一张券码的标识（验券时返回），是否必填：是
     */
    private String certificate_id;
}
