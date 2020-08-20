package com.example.api.webapi.config;

import com.example.api.webapi.config.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
/**
 * Spring Security 配置类
 * @EnableGlobalMethodSecurity 开启注解的权限控制，默认是关闭的。
 * prePostEnabled：使用表达式实现方法级别的控制，如：@PreAuthorize("hasRole('ADMIN')")
 * securedEnabled: 开启 @Secured 注解过滤权限，如：@Secured("ROLE_ADMIN")
 * jsr250Enabled: 开启 @RolesAllowed 注解过滤权限，如：@RolesAllowed("ROLE_ADMIN")
 *
 * @author K. L. Mao
 * @create 2019/1/11
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled=true,jsr250Enabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder())
        ;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("sss");

        /**
         * 在 UsernamePasswordAuthenticationFilter 之前添加 JwtAuthenticationTokenFilter
         */
        http
        .addFilterAt(new MyUsernamePasswordAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new MyGenericFilterBean(), UsernamePasswordAuthenticationFilter.class)
        ;
        //开启跨域,关闭CSRF
        http.csrf().disable().cors()
        .configurationSource(corsConfigurationSource())
        ;
        //登录配置
        http
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(new MyAuthenticationSuccessHandler())//登录成功的处理
                .failureHandler(new MyAuthenticationFailureHandler())//登录失败处理
                ;
        //授权认证
        http.authorizeRequests()
                .antMatchers("/authentication/form")//登录url
                .permitAll()//登录页面不拦截
                .antMatchers("/logout")//退出url
                .permitAll()//退出页面不拦截
                .anyRequest().authenticated();//所有请求都认证

        //配置退出
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new MyLogoutSuccessHandler());
        http.exceptionHandling()
                .authenticationEntryPoint(new MyAuthenticationEntryPoint())//登录过期/未登录处理
                .accessDeniedHandler(new MyAccessDeineHandler())//权限不足处理
         ;
        //设置无session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


    }

    /**
     * 密码加密
     * @return 返回加密后的密码
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        //$2a$10$UAK3qVF0IMl/1LAk6tu/mORx.G/.QQXIPzfojCqp/izgPMvfzUUf2
        //$2a$10$.2wAwpe1moscPhgzo3gTyu5cM6HlB5jXC1EOvx/1YZ3Udm3dqG4oa
    }

    @Override
    public void configure(WebSecurity web) {
        //将项目中静态资源路径开放出来
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers("/swagger-ui.html")
                .antMatchers("/v2/**")
                .antMatchers("/webjars/**")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/config/**", "/css/**", "/fonts/**", "/img/**", "/js/**");
    }

private CorsConfigurationSource corsConfigurationSource() {
    CorsConfigurationSource source =   new UrlBasedCorsConfigurationSource();
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.addAllowedOrigin("*");	//同源配置，*表示任何请求都视为同源，若需指定ip和端口可以改为如“localhost：8080”，多个以“，”分隔；
    corsConfiguration.addAllowedHeader("*");//header，允许哪些header，本案中使用的是token，此处可将*替换为token；
    corsConfiguration.addAllowedMethod("*");//允许的请求方法，PSOT、GET等
    corsConfiguration.setAllowCredentials(true);//允许Credentials
    ((UrlBasedCorsConfigurationSource) source).registerCorsConfiguration("/**",corsConfiguration); //配置允许跨域访问的url
    return source;
    }
//    @Bean
//    public WebMvcConfigurer corsConfig(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry){
//                registry.addMapping("/**");
//            }
//        };
//    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    //    自定义登陆时解析json格式数据
    @Bean
    MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter() throws Exception {
        MyUsernamePasswordAuthenticationFilter filter = new MyUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(super.authenticationManagerBean());
        filter.setFilterProcessesUrl("/authentication/form");
        filter.setAuthenticationSuccessHandler(new MyAuthenticationSuccessHandler());
        filter.setAuthenticationFailureHandler(new MyAuthenticationFailureHandler());
        return filter;
    }



    /**
     * 注入自定义PermissionEvaluator (hasPermission)
     */
    @Bean
    public DefaultWebSecurityExpressionHandler userSecurityExpressionHandler(){
        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setPermissionEvaluator(new MyPermissionEvaluator());
        return handler;
    }
}
