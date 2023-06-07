package io.github.feng.common.resp;

import lombok.Data;

/**
 * @ClassName AccessTokenResp
 * @Description: token响应
 * @Author fengwensheng
 * @Date 2022/10/19
 * @Version V1.0
 **/
@Data
public class AccessTokenResp {

    /**
     * access_token 接口调用凭证超时时间，单位（秒）
     */
    private long expires_in;
    /**
     * 接口调用凭证
     */
    private String access_token;
    /**
     * 错误码描述
     */
    private String description;
    /**
     * 错误码
     */
    private long error_code;
}
