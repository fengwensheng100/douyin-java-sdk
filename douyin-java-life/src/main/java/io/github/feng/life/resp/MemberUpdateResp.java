package io.github.feng.life.resp;

import lombok.Data;

/**
 * @ClassName MemberUpdateResp
 * @Description: 会员信息更新响应
 * @Author fengwensheng
 * @Date 2022/10/19
 * @Version V1.0
 **/
@Data
public class MemberUpdateResp {

    /**
     * 错误码，0为成功
     */
    private int error_code;
    /**
     * 错误码描述
     */
    private String description;
}
