package ua.kiev.dk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import javax.sql.DataSource;


@Configuration
//@EnableWebSecurity
@EnableWebMvcSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/MedAutomation/").authenticated()
                .antMatchers("/MedAutomation/show_crews").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/MedAutomation/departure_point_info").access("hasRole('ROLE_USER')")
                .antMatchers("/MedAutomation/more__req_info").access("hasRole('ROLE_USER')")
                .antMatchers("/MedAutomation/close_request").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/MedAutomation/show_institutions").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/MedAutomation/show_all_units").access("hasRole('ROLE_USER')")
                .antMatchers("/MedAutomation/show_archive").access("hasRole('ROLE_USER')")
                .antMatchers("/MedAutomation/open_add_request_page").access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin().loginPage("/login")
                .permitAll()
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf();
    }
}