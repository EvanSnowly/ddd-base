package me.wuxuefeng.dddbase.api.mapper;

import me.wuxuefeng.dddbase.api.request.UserLoginRequest;
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
public interface UserMapper {

    /**
     * 将登录请求 DTO 转换为登录命令对象（或原样返回）
     *
     * @param userLoginRequest 登录请求
     * @return 转换后的登录请求
     */
    UserLoginRequest toLoginCommand(UserLoginRequest userLoginRequest);
}
