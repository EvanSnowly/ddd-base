package me.wuxuefeng.dddbase.application.command;

public record UserLoginCommand(
        String userName,
        String password
) {
}
