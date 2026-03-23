package me.wuxuefeng.dddbase.infuastructure.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.wuxuefeng.dddbase.domain.module.User;
import me.wuxuefeng.dddbase.infuastructure.mp.mapper.UserMapper;
import me.wuxuefeng.dddbase.infuastructure.mp.service.UserIService;
import org.springframework.stereotype.Component;

@Component
public class UserIServiceImpl extends ServiceImpl<UserMapper, User> implements UserIService {
}
