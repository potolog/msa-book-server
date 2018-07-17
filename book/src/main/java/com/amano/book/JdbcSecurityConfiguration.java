package com.amano.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.ResultSet;

/*
 * # TODO : Spring boot Security : 2. 인증 로직을 만들어 보자.    https://gs.saro.me/#!m=elec&jn=791
 */

@Configuration
@EnableGlobalAuthentication
public class JdbcSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(JdbcTemplate jdbcTemplate) {
        RowMapper<User> userRowMapper = (ResultSet rs, int i) ->
            new User(
                    rs.getString("account_name"),
                    rs.getString("password"),
                    rs.getBoolean("enabled"),
                    rs.getBoolean("enabled"),
                    rs.getBoolean("enabled"),
                    rs.getBoolean("enabled"),
                    AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN")
            );
        return username -> jdbcTemplate.queryForObject("SELECT * FROM account WHERE account_name = ?", userRowMapper, username);
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    PasswordEncoder passwordEncoder()
    {
        // 스프링에서 제공하는 기본 암호 인코더
        // return new BCryptPasswordEncoder();
        // 커스텀 인코더를 사용하고있다.
        return new MyPasswordEncoder();
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
    //  auth.userDetailsService(this.userDetailsService);
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    // 암호 인코더 커스텀 설정
    public static class MyPasswordEncoder implements PasswordEncoder
    {
        @Override
        public String encode(CharSequence rawPassword)
        {
            System.out.println(String.format("MyPasswordEncoder.encode : rawPassword = %s", rawPassword));

            // 여기서는 이렇게 처리하였지만 예를들어 sha-2 / sha-3 같은 해시를 접목시킬 수 있다.
            // 여기서는 간단히 EN-을 붙여 확인하는 용도!
        //  return "EN-" + rawPassword.toString();
            return rawPassword.toString();
        }

        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword)
        {
            System.out.println(String.format("MyPasswordEncoder.matches : rawPassword = %s, encodePassword : %s", rawPassword, encodedPassword));
            // rawPassword 현재 들어온 값 | encodedPassword 매칭되는 계정에 있는 값
            return encodedPassword.equals(encode(rawPassword));
        }
    }

}
