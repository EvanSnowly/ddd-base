package me.wuxuefeng.dddbase.api.mapper;

import me.wuxuefeng.dddbase.api.request.UserLoginRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserLoginRequest toLoginCommand(UserLoginRequest userLoginRequest);
}
