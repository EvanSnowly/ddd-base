package me.wuxuefeng.dddbase.application.command;

/**
 * 用户注册命令对象
 *
 * @author wuxuefeng
 * @since 1.0.0
 */
public record UserRegisterCommand(
        String userName,
        String password,
        String phone,
        String email
) {
}
