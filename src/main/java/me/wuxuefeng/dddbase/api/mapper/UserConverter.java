package me.wuxuefeng.dddbase.api.mapper;

import me.wuxuefeng.dddbase.api.request.UserLoginRequest;
import me.wuxuefeng.dddbase.api.request.UserRegisterRequest;
import me.wuxuefeng.dddbase.application.command.UserLoginCommand;
import me.wuxuefeng.dddbase.application.command.UserRegisterCommand;
import me.wuxuefeng.dddbase.domain.module.User;
import org.mapstruct.Mapper;

/**
 * 用户相关对象映射转换器
 * <p>
 * 基于 MapStruct 实现不同层级对象（DTO/Command/Entity）之间的智能转换。
 * </p>
 *
 * @author wuxuefeng
 * @since 1.0.0
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

    /**
     * 将登录请求 DTO 转换为登录命令对象
     *
     * @param userLoginRequest 登录请求
     * @return 转换后的登录命令
     */
    UserLoginCommand toUserLoginCommand(UserLoginRequest userLoginRequest);

    /**
     * 将注册请求 DTO 转换为注册命令对象
     *
     * @param userRegisterRequest 注册请求
     * @return 转换后的注册命令
     */
    UserRegisterCommand toUserRegisterCommand(UserRegisterRequest userRegisterRequest);

    /**
     * 将注册命令转换为领域实体
     *
     * @param userRegisterCommand 注册命令
     * @return 用户领域实体
     */
    User toUser(UserRegisterCommand userRegisterCommand);
}
