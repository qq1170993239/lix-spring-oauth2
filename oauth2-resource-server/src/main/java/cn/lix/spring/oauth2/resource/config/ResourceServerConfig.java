package cn.lix.spring.oauth2.resource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration

//开启oauth2,reousrce server模式
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            // 以下为配置所需保护的资源路径及权限，需要与认证服务器配置的授权部分对应
            .antMatchers("/").hasAuthority("SystemContent")
            .antMatchers("/view/**").hasAuthority("SystemContentView")
            .antMatchers("/insert/**").hasAuthority("SystemContentInsert")
            .antMatchers("/update/**").hasAuthority("SystemContentUpdate")
            .antMatchers("/delete/**").hasAuthority("SystemContentDelete");
    }
}
