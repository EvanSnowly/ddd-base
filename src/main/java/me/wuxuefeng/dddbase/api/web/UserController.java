package me.wuxuefeng.dddbase.api.web;

import jakarta.annotation.Resource;
import me.wuxuefeng.dddbase.api.base.Result;
import me.wuxuefeng.dddbase.api.request.UserLoginRequest;
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


    /**
     * 用户登录接口
     *
     * @param userLoginRequest 登录请求参数（包含用户名和密码）
     * @return 统一响应结果Result，无返回数据
     */
    @PostMapping("/login")
    public Result<Void> login(@RequestBody UserLoginRequest userLoginRequest) {

        userApplicationService.login(userLoginRequest);

        return Result.success();

    }
}
