package cn.lix.spring.oauth2.sdk.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 角色权限表(tb_role_permission)表实体类
 *
 * @author lix
 * @since 2020-09-04 15:37:40
 */
public class TbRolePermission {


    @TableId
    @TableField("id")
    private Long id;


    //角色 ID    
    @TableField("role_id")
    private Long roleId;


    //权限 ID    
    @TableField("permission_id")
    private Long permissionId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

}