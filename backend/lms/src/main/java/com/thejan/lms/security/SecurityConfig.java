package com.thejan.lms.security;


import com.thejan.lms.entity.Role;
import com.thejan.lms.security.filter.JWTAuthorizationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/user/**").authenticated()
                .requestMatchers("/student/**").hasAuthority(Role.STUDENT.name())
                .requestMatchers("/teacher/**").hasAuthority(Role.TEACHER.name())
                .requestMatchers("/admin/**").hasAuthority(Role.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutUrl("/auth/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());

                return http.build();

    }
}

//        http.cors().and().logout().logoutUrl("/auth/logout").logoutSuccessUrl("/auth/logout#success")
//                .clearAuthentication(true)
//                .invalidateHttpSession(true)
//                .deleteCookies("SESSION_ID")
//                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK));
//
//        http.authorizeHttpRequests().requestMatchers("/user/**").authenticated();
//        http.authorizeHttpRequests().requestMatchers("/student/**").hasAuthority("STUDENT");
//        http.authorizeHttpRequests().requestMatchers("/teacher/**").hasAuthority("TEACHER");
//        http.authorizeHttpRequests().requestMatchers("/admin/**").hasAuthority("ADMIN");
//        http.authorizeHttpRequests().anyRequest().permitAll();
//
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.authenticationProvider(authenticationProvider);
//        http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
//}

/*    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/authenticate");
        http
            .headers().frameOptions().disable() // New Line: the h2 console runs on a "frame". By default, Spring Security prevents rendering within an iframe. This line disables its prevention.
            .and()
            .csrf().disable()
                .authorizeRequests()
                .requestMatchers(HttpMethod.POST, SecurityConstants.REGISTER_PATH).permitAll()
                .anyRequest().authenticated()
            .and()
            .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
            .addFilter(authenticationFilter)
            .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }*/