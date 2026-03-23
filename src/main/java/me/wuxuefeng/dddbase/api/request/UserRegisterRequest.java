package me.wuxuefeng.dddbase.api.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * 用户注册请求 DTO
 *
 * @author wuxuefeng
 * @since 1.0.0
 */
public record UserRegisterRequest(
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
        String password,

        /**
         * 手机号
         */
        @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
        String phone,

        /**
         * 邮箱
         */
        @Email(message = "邮箱格式不正确")
        String email
) {
}
