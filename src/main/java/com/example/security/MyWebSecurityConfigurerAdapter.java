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
                //WEB
                .antMatchers("/web/family/**").permitAll()
                .antMatchers("/web/family/list/**").permitAll()
                .antMatchers("/web/family/new/**").permitAll()

                .antMatchers("/web/subfamily/**").permitAll()
                .antMatchers("/web/subfamily/list/**").permitAll()
                .antMatchers("/web/subfamily/new/**").permitAll()

                .antMatchers("/web/drug/**").permitAll()
                .antMatchers("/web/drug/list/**").permitAll()
                .antMatchers("/web/drug/new/**").permitAll()

                .antMatchers("/web/exchange/**").permitAll()
                .antMatchers("/web/exchange/list/**").permitAll()
                .antMatchers("/web/exchange/new/**").permitAll()
                //API
                .antMatchers("/api/family/**").permitAll()
                .antMatchers("/api/family/list/**").permitAll()
                .antMatchers("/api/family/new/**").permitAll()

                .antMatchers("/api/subfamily/**").permitAll()
                .antMatchers("/api/subfamily/list/**").permitAll()
                .antMatchers("/api/subfamily/new/**").permitAll()

                .antMatchers("/api/drug/**").permitAll()
                .antMatchers("/api/drug/list/**").permitAll()
                .antMatchers("/api/drug/new/**").permitAll()

                .antMatchers("/api/exchange/**").permitAll()
                .antMatchers("/api/exchange/list/**").permitAll()
                .antMatchers("/api/exchange/new/**").permitAll()

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
        http.csrf().disable(); //h2-console
        http.headers().frameOptions().disable(); //h2-console

    }
}
