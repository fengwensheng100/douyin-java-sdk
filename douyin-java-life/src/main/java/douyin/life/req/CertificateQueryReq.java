package douyin.life.req;

import lombok.Data;

/**
 * @ClassName CertificateQueryReq
 * @Description: 券状态批量查询请求
 * @Author fengwensheng
 * @Date 2022/10/19
 * @Version V1.0
 **/
@Data
public class CertificateQueryReq {

    /**
     * 验券准备接口返回的加密券码（传参前需要先进行URL编码），非必传 （encrypted_code和order_id二者必传一个）
     */
    private String encrypted_code;
    /**
     * 抖音订单号，非必传 （encrypted_code和order_id二者必传一个）
     */
    private String order_id;
}
