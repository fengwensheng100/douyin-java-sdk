package com.github.feng.life.resp;

import lombok.Data;

/**
 * @ClassName CertificateCancelResp
 * @Description: 验券响应
 * @Author fengwensheng
 * @Date 2022/10/19
 * @Version V1.0
 **/
@Data
public class CertificateCancelResp {

    /**
     * 错误码，0为成功
     */
    private int error_code;
    /**
     * 错误码描述
     */
    private String description;
}
