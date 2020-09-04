package cn.lix.spring.oauth2.sdk.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * 权限表(tb_permission)表实体类
 *
 * @author lix
 * @since 2020-09-04 15:37:34
 */
public class TbPermission {


    @TableId
    @TableField("id")
    private Long id;


    //父权限    
    @TableField("parent_id")
    private Long parentId;


    //权限名称    
    @TableField("name")
    private String name;


    //权限英文名称    
    @TableField("enname")
    private String enname;


    //授权路径    
    @TableField("url")
    private String url;


    //备注    
    @TableField("description")
    private String description;


    @TableField("created")
    private Date created;


    @TableField("updated")
    private Date updated;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

}