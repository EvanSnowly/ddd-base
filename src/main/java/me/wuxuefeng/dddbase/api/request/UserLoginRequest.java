package me.wuxuefeng.dddbase.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 用户登录请求对象
 *
 * @param userName 用户账号
 * @param password 用户密码
 */
public record UserLoginRequest(
        @NotBlank
        @Size(min = 8, max = 12)
        String userName,
        @NotBlank
        @Size(min = 8, max = 12)
        String password
) {
}
