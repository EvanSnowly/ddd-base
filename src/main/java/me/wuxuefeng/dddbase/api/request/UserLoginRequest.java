package me.wuxuefeng.dddbase.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 用户登录请求 DTO
 * <p>
 * 用于前端向后端传递登录信息，包含基本的数据校验。
 * </p>
 *
 * @param userName 用户账号
 * @param password 用户密码
 * @author wuxuefeng
 * @since 1.0.0
 */
public record UserLoginRequest(
        /**
         * 用户名（必填，8-12位）
         */
        @NotBlank(message = "用户名不能为空")
        @Size(min = 8, max = 12, message = "用户名长度必须在 8-12 位之间")
        String userName,

        /**
         * 密码（必填，8-12位）
         */
        @NotBlank(message = "密码不能为空")
        @Size(min = 8, max = 12, message = "密码长度必须在 8-12 位之间")
        String password
) {
}
