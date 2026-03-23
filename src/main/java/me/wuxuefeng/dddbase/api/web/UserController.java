package me.wuxuefeng.dddbase.api.web;

import jakarta.annotation.Resource;
import me.wuxuefeng.dddbase.api.base.Result;
import me.wuxuefeng.dddbase.api.request.UserLoginRequest;
import me.wuxuefeng.dddbase.application.service.UserApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserApplicationService userApplicationService;


    @PostMapping("/login")
    public Result<Void> login(@RequestBody UserLoginRequest userLoginRequest) {

        userApplicationService.login(userLoginRequest);

        return Result.success();

    }
}
