package me.wuxuefeng.dddbase.infuastructure.repositoryImpl;

import jakarta.annotation.Resource;
import me.wuxuefeng.dddbase.domain.module.User;
import me.wuxuefeng.dddbase.domain.repository.UserRepository;
import me.wuxuefeng.dddbase.infuastructure.mp.service.UserIService;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {

    @Resource
    private UserIService userIService;

    @Override
    public User findByUserName(String userName) {
        return userIService.lambdaQuery().eq(User::getUserName, userName).one();
    }

    @Override
    public boolean updateById(User user) {
        return userIService.updateById(user);
    }


}
