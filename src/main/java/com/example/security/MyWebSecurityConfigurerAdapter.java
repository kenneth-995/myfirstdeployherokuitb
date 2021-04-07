package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableJpaAuditing

public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService myUserDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(myUserDetailService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //autoritzacio
        http.authorizeRequests()
                .antMatchers("/", "/login", "/registre","/empleats/list").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/family/**").permitAll()
                .antMatchers("/family/list/**").permitAll()
                .antMatchers("/family/new/**").permitAll()
                .antMatchers("/subfamily/**").permitAll()
                .antMatchers("/subfamily/list/**").permitAll()
                .antMatchers("/subfamily/new/**").permitAll()


//                .antMatchers(
//                        "/empleats/edit/{id}").hasAnyRole("USER", "ADMIN") //"/empleats/list", **.hasAnyRole("USER", "ADMIN")**

//                .antMatchers(
//                        "/empleats/new/**",
//                        /*"“/empleats/new/submit",*/
//                        "/empleats/eliminar/**"
//                        /*"/empleats/eliminar/{id}"*/).hasRole("ADMIN")

                //.antMatchers("/static").permitAll()


                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .and()
                .logout().permitAll();

        //development
        http.csrf().disable(); //per h2-console
        http.headers().frameOptions().disable(); //per h2-console

    }
}
