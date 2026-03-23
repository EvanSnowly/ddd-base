package me.wuxuefeng.dddbase.application.service;

import jakarta.annotation.Resource;
import me.wuxuefeng.dddbase.api.request.UserLoginRequest;
import me.wuxuefeng.dddbase.domain.module.User;
import me.wuxuefeng.dddbase.domain.repository.UserRepository;
import me.wuxuefeng.dddbase.infuastructure.exception.UserErrorCode;
import me.wuxuefeng.dddbase.infuastructure.exception.UserException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserApplicationService {

    @Resource
    private UserRepository userRepository;

    public void login(UserLoginRequest userLoginRequest) {
        User user = userRepository.findByUserName(userLoginRequest.userName());

        if (Objects.isNull(user)) throw new UserException(UserErrorCode.USER_EMPTY);

        boolean auth = user.auth(userLoginRequest.password());

        if (!auth) throw new UserException(UserErrorCode.USER_AUTH_ERROR);

        user.loginSuccess();

        userRepository.updateById(user);
    }

}
