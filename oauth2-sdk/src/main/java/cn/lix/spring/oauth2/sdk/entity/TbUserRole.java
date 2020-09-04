package cn.lix.spring.oauth2.sdk.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 用户角色表(tb_user_role)表实体类
 *
 * @author lix
 * @since 2020-09-04 15:37:41
 */
public class TbUserRole {


    @TableId
    @TableField("id")
    private Long id;


    //用户 ID    
    @TableField("user_id")
    private Long userId;


    //角色 ID    
    @TableField("role_id")
    private Long roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}