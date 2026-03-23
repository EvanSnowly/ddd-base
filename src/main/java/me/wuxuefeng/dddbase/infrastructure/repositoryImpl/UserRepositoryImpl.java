package me.wuxuefeng.dddbase.infrastructure.repositoryImpl;

import jakarta.annotation.Resource;
import me.wuxuefeng.dddbase.domain.module.User;
import me.wuxuefeng.dddbase.domain.repository.UserRepository;
import me.wuxuefeng.dddbase.infrastructure.mp.service.UserIService;
import org.springframework.stereotype.Component;

/**
 * 用户仓储接口实现类
 * <p>
 * 属于基础设施层，负责将领域层的仓储定义转化为具体的数据持久化操作（如数据库访问）。
 * </p>
 *
 * @author wuxuefeng
 * @since 1.0.0
 */
@Component
public class UserRepositoryImpl implements UserRepository {

    @Resource
    private UserIService userIService;

    /**
     * 根据用户名查询用户（通过 MyBatis Plus 实现）
     *
     * @param userName 用户名
     * @return 用户实体
     */
    @Override
    public User findByUserName(String userName) {
        return userIService.lambdaQuery()
                .eq(User::getUserName, userName)
                .one();
    }

    /**
     * 保存新用户信息
     *
     * @param user 待保存的用户实体
     * @return 是否成功
     */
    @Override
    public boolean save(User user) {
        return userIService.save(user);
    }

    /**
     * 根据 ID 更新用户（通过 MyBatis Plus 实现）
     *
     * @param user 用户实体
     * @return 是否成功
     */
    @Override
    public boolean updateById(User user) {
        return userIService.updateById(user);
    }

}
