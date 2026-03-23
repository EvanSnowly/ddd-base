package me.wuxuefeng.dddbase.domain.repository;

import me.wuxuefeng.dddbase.domain.module.User;

/**
 * 用户领域仓储接口
 * <p>
 * 负责定义用户实体的持久化及查询标准，属于领域层。
 * 具体实现由基础设施层提供。
 * </p>
 *
 * @author wuxuefeng
 * @since 1.0.0
 */
public interface UserRepository {

    /**
     * 根据用户名查询用户
     *
     * @param userName 用户名
     * @return 用户实体，不存在则返回 null
     */
    User findByUserName(String userName);

    /**
     * 根据 ID 更新用户
     *
     * @param user 用户实体（包含待更新的 ID）
     * @return 是否成功
     */
    boolean updateById(User user);
}
