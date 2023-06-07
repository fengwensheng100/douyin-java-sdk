package io.github.feng.life.resp;

import lombok.Data;

import java.util.List;

/**
 * @ClassName CertificateVerifyResp
 * @Description: 验券响应
 * @Author fengwensheng
 * @Date 2022/10/19
 * @Version V1.0
 **/
@Data
public class CertificateVerifyResp {

    /**
     * 错误码，0为成功
     */
    private int error_code;
    /**
     * 错误码描述
     */
    private String description;
    /**
     * 验券结果
     */
    private List<VerifyResults> verify_results;
    @Data
    public static class VerifyResults {
        /**
         * 验券结果码，0表示成功，非0表示失败
         */
        private int result;
        /**
         * 验券结果说明
         */
        private String msg;
        /**
         * 代表验券传入的code或encrypted_code
         */
        private String code;
        /**
         * 代表券码一次核销的标识（撤销时需要）
         */
        private String verify_id;
        /**
         * 代表一张券码的标识（撤销时需要）
         */
        private String certificate_id;
        /**
         * 代表抖音团购券的12位原始券码（抖音加密券码核销时）
         */
        private String origin_code;
        /**
         * 代表企业号商家总店id（查询验券历史时需要）
         */
        private String account_id;
    }
}
