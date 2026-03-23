package me.wuxuefeng.dddbase.domain.repository;

import me.wuxuefeng.dddbase.domain.module.User;

public interface UserRepository {

    User findByUserName(String userName);

    boolean updateById(User user);
}
