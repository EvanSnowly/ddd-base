package me.wuxuefeng.dddbase.infuastructure.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.wuxuefeng.dddbase.domain.module.User;
import me.wuxuefeng.dddbase.infuastructure.mp.mapper.UserMapper;
import me.wuxuefeng.dddbase.infuastructure.mp.service.UserIService;
import org.springframework.stereotype.Component;

/**
 * 用户 MyBatis Plus Service 实现类
 * <p>
 * 封装底层的 MyBatis Plus 操作。
 * </p>
 *
 * @author wuxuefeng
 * @since 1.0.0
 */
@Component
public class UserIServiceImpl extends ServiceImpl<UserMapper, User> implements UserIService {
}
