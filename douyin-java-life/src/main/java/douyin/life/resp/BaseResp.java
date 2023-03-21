package douyin.life.resp;

import lombok.Data;

/**
 * @ClassName CertificatePrepareResp
 * @Description: 基础响应
 * @Author fengwensheng
 * @Date 2022/10/19
 * @Version V1.0
 **/
@Data
public class BaseResp<T> {

    private T data;
    private Extra extra;
    private String message;

    @Data
    public static class Extra {
        private int error_code;
        private String description;
        private int sub_error_code;
        private String sub_description;
        private long now;
        private String logid;
    }
}
