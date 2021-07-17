package com.uca.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Autowired
    private CustomLoginSuccessHandler customLoginSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/afiliate").permitAll()
                .antMatchers("/aliados").permitAll()
                .antMatchers("/delegados").permitAll()
                .antMatchers("/eventos").permitAll()
                .antMatchers("/nuestrotrabajo").permitAll()
                .antMatchers("/publicaciones").permitAll()
                .antMatchers("/quienessomos").permitAll()
                .antMatchers("/recursos").permitAll()
                .antMatchers("/antecedentes").permitAll()
                .antMatchers("/delegadosnacionales").permitAll()
                .antMatchers("/delegadossubregionales").permitAll()
                .antMatchers("/estructuraautoridades").permitAll()
                .antMatchers("/legalizacion").permitAll()
                .antMatchers("/monitoreo").permitAll()
                .antMatchers("/webinars").permitAll()
                .antMatchers("/objetivos").permitAll()
                .antMatchers("/mostrardelegados").permitAll()
                .antMatchers("/mostrardelegadon").permitAll()
                .antMatchers("/delegadosnacionales/{id}").permitAll()
                .antMatchers("/delegadossubregionales/{id}").permitAll()
                .antMatchers("/monitoreo").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable().formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .successHandler(customLoginSuccessHandler)
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and()
                .exceptionHandling()
                .accessDeniedPage("/acess-denied");

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/img/**", "/css/**", "/js/**");
    }
}
