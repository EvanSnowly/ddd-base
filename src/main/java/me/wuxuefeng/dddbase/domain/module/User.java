package me.wuxuefeng.dddbase.domain.module;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户领域实体 (Domain Entity)
 * <p>
 * 包含用户的核心属性及业务行为。
 * </p>
 *
 * @author wuxuefeng
 * @since 1.0.0
 */
@Data
@TableName("t_user")
public class User {

    /**
     * 用户 ID (主键自增)
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户账号 (唯一标识)
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户密码 (应存储哈希后的值)
     */
    @TableField(value = "password")
    private String password;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 邮箱地址
     */
    @TableField("email")
    private String email;

    /**
     * 最近一次成功登录的时间
     */
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    /**
     * 记录创建时间 (MyBatis Plus 自动填充)
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /* ---------------- 领域行为 (Domain Logic) ---------------- */

    /**
     * 验证用户密码是否正确
     * <p>
     * 建议：在生产环境中应使用加密匹配逻辑，例如 BCrypt.checkpw(raw, hash)。
     * </p>
     *
     * @param inputPassword 输入的明文密码
     * @return 验证通过返回 true，否则返回 false
     */
    public boolean auth(String inputPassword) {
        if (this.password == null) {
            return false;
        }
        return this.password.equals(inputPassword);
    }

    /**
     * 业务逻辑：处理登录成功后的副作用
     * <p>
     * 更新最近登录时间。未来可扩展如积分奖励、连续登录天数更新等。
     * </p>
     */
    public void loginSuccess() {
        this.lastLoginTime = LocalDateTime.now();
    }
}
