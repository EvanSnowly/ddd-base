package me.wuxuefeng.dddbase.application.service;

import jakarta.annotation.Resource;
import me.wuxuefeng.dddbase.api.request.UserLoginRequest;
import me.wuxuefeng.dddbase.domain.module.User;
import me.wuxuefeng.dddbase.domain.repository.UserRepository;
import me.wuxuefeng.dddbase.infuastructure.exception.UserErrorCode;
import me.wuxuefeng.dddbase.infuastructure.exception.UserException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用户应用服务层
 * <p>
 * 负责协调领域层对象完成业务逻辑，属于应用层。
 * 该层不应包含核心业务规则。
 * </p>
 *
 * @author wuxuefeng
 * @since 1.0.0
 */
@Service
public class UserApplicationService {

    @Resource
    private UserRepository userRepository;

    /**
     * 用户登录处理流程
     * <p>
     * 1. 根据用户名查询用户是否存在<br/>
     * 2. 调用领域对象进行密码校验<br/>
     * 3. 校验成功后更新登录成功后的状态<br/>
     * 4. 将更新后的实体进行持久化
     * </p>
     *
     * @param userLoginRequest 登录请求参数
     * @throws UserException 当用户不存在或认证失败时抛出
     */
    public void login(UserLoginRequest userLoginRequest) {
        // 1. 获取领域实体
        User user = userRepository.findByUserName(userLoginRequest.userName());

        // 2. 基础合法性检查
        if (Objects.isNull(user)) {
            throw new UserException(UserErrorCode.USER_EMPTY);
        }

        // 3. 执行领域行为：认证
        boolean auth = user.auth(userLoginRequest.password());
        if (!auth) {
            throw new UserException(UserErrorCode.USER_AUTH_ERROR);
        }

        // 4. 执行领域行为：登录成功后的状态变更
        user.loginSuccess();

        // 5. 持久化状态变更
        userRepository.updateById(user);
    }

}
