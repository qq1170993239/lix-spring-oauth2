package cn.lix.spring.oauth2.service;

import cn.lix.spring.oauth2.sdk.dao.TbPermissionDAO;
import cn.lix.spring.oauth2.sdk.dao.TbUserDAO;
import cn.lix.spring.oauth2.sdk.entity.TbPermission;
import cn.lix.spring.oauth2.sdk.entity.TbUser;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义用户认证与授权
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-04-04 23:57:04
 * @see com.funtl.oauth2.server.config
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserDAO userDAO;

    @Autowired
    private TbPermissionDAO permissionDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        TbUser tbUser = userDAO.selectOne(new QueryWrapper<TbUser>().eq("username", username));
        if (tbUser == null) {
            return null;
        }
        TbPermission permission = permissionDAO.selectById(tbUser.getId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(4);
        // 声明用户授权
        if (permission != null && permission.getEnname() != null) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getEnname());
            grantedAuthorities.add(grantedAuthority);
        }

        // 由框架完成认证工作
        return new User(tbUser.getUsername(), tbUser.getPassword(), grantedAuthorities);
    }
}