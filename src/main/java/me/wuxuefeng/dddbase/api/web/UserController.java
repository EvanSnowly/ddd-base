package me.wuxuefeng.dddbase.api.web;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import me.wuxuefeng.dddbase.api.response.Result;
import me.wuxuefeng.dddbase.api.mapper.UserConverter;
import me.wuxuefeng.dddbase.api.request.UserLoginRequest;
import me.wuxuefeng.dddbase.api.request.UserRegisterRequest;
import me.wuxuefeng.dddbase.application.command.UserLoginCommand;
import me.wuxuefeng.dddbase.application.command.UserRegisterCommand;
import me.wuxuefeng.dddbase.application.service.UserApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关接口控制器
 * <p>
 * 负责接收外部 RESTful 请求，并将其转发至应用服务层进行业务处理。
 * </p>
 *
 * @author wuxuefeng
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserApplicationService userApplicationService;

    @Resource
    private UserConverter userConverter;


    /**
     * 用户注册接口
     *
     * @param userRegisterRequest 注册请求参数
     * @return 统一响应结果 Result
     */
    @PostMapping("/register")
    public Result<Void> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {

        UserRegisterCommand userRegisterCommand = userConverter.toUserRegisterCommand(userRegisterRequest);

        userApplicationService.register(userRegisterCommand);

        return Result.success();
    }

    /**
     * 用户登录接口
     *
     * @param userLoginRequest 登录请求参数（包含用户名和密码）
     * @return 统一响应结果Result，无返回数据
     */
    @PostMapping("/login")
    public Result<Void> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {


        UserLoginCommand userLoginCommand = userConverter.toUserLoginCommand(userLoginRequest);

        userApplicationService.login(userLoginCommand);

        return Result.success();
    }
}
