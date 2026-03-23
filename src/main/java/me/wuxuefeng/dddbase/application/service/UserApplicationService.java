package me.wuxuefeng.dddbase.application.service;

import jakarta.annotation.Resource;
import me.wuxuefeng.dddbase.api.mapper.UserConverter;
import me.wuxuefeng.dddbase.application.command.UserLoginCommand;
import me.wuxuefeng.dddbase.application.command.UserRegisterCommand;
import me.wuxuefeng.dddbase.domain.module.User;
import me.wuxuefeng.dddbase.domain.repository.UserRepository;
import me.wuxuefeng.dddbase.infrastructure.exception.UserErrorCode;
import me.wuxuefeng.dddbase.infrastructure.exception.UserException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Resource
    private UserConverter userConverter;

    /**
     * 用户注册处理流程
     * <p>
     * 1. 检查用户名是否已存在<br/>
     * 2. 将命令转换为领域对象<br/>
     * 3. 持久化用户信息
     * </p>
     *
     * @param userRegisterCommand 注册命令对象
     * @throws UserException 当用户名已存在时抛出
     */
    @Transactional(rollbackFor = Exception.class)
    public void register(UserRegisterCommand userRegisterCommand) {
        // 1. 业务校验：用户名查重
        User existingUser = userRepository.findByUserName(userRegisterCommand.userName());
        if (Objects.nonNull(existingUser)) {
            throw new UserException(UserErrorCode.USER_ALREADY_EXISTS);
        }

        // 2. 转换为领域实体
        User user = userConverter.toUser(userRegisterCommand);

        // 3. 执行持久化
        userRepository.save(user);
    }

    /**
     * 用户登录处理流程
     * <p>
     * 1. 根据用户名查询用户是否存在<br/>
     * 2. 调用领域对象进行密码校验<br/>
     * 3. 校验成功后更新登录成功后的状态<br/>
     * 4. 将更新后的实体进行持久化
     * </p>
     *
     * @param userLoginCommand 登录请求参数
     * @throws UserException 当用户不存在或认证失败时抛出
     */
    public void login(UserLoginCommand userLoginCommand) {
        // 1. 获取领域实体
        User user = userRepository.findByUserName(userLoginCommand.userName());

        // 2. 基础合法性检查
        if (Objects.isNull(user)) {
            throw new UserException(UserErrorCode.USER_EMPTY);
        }

        // 3. 执行领域行为：认证
        boolean auth = user.auth(userLoginCommand.password());
        if (!auth) {
            throw new UserException(UserErrorCode.USER_AUTH_ERROR);
        }

        // 4. 执行领域行为：登录成功后的状态变更
        user.loginSuccess();

        // 5. 持久化状态变更
        userRepository.updateById(user);
    }

}
