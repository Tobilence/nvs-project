package at.spengergasse.nvsproject.configuration;

import at.spengergasse.nvsproject.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * This class contains the Basic Security Configuration
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    /**
     * Tells the Application how the authentication should be done
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(daoAuthenticationProvider());
    }

    /**
     * Tells the Application which Routes should need authorization
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
                .antMatchers("/authentication")
                .permitAll()
          .anyRequest()
          .permitAll() //TODO change to authenticated() later
          .and()
            .httpBasic()
          .and()
            .csrf()
            .disable();

    }

    /**
     * Creates the authentication provider
     */
    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(userDetailsService);

        return authenticationProvider;
    }
}