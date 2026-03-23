package me.wuxuefeng.dddbase.domain.module;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("t_user")
public class User {

    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户账号
     * 指定数据库字段名，确保 LambdaQuery 能够正确解析
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 最近登录时间
     */
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    /**
     * 创建时间
     * fill = FieldFill.INSERT: 自动填充，无需手动 set
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /* ---------------- 领域行为 (Domain Logic) ---------------- */

    /**
     * 验证密码
     * 建议：实际项目中应使用 passwordEncoder.matches(raw, hash)
     */
    public boolean auth(String inputPassword) {
        if (this.password == null) {
            return false;
        }
        return this.password.equals(inputPassword);
    }

    /**
     * 业务逻辑：更新登录状态
     */
    public void loginSuccess() {
        this.lastLoginTime = LocalDateTime.now();
        // 这里可以扩展更多逻辑，如记录登录日志
    }
}