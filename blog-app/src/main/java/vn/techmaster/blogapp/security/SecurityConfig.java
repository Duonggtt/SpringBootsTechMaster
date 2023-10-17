package vn.techmaster.blogapp.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        String[] PUBLIC_ROLE ={"/"};
        http.authorizeHttpRequests((authz) -> authz
//                .requestMatchers(PUBLIC_ROLE).permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/author").hasRole("AUTHOR")
                .requestMatchers("/sale").hasRole("SALE")
                .requestMatchers("/").hasRole("USER")
                .anyRequest().authenticated()
        );
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123")
                .roles("USER","ADMIN")
                .build();
        UserDetails author = User.withDefaultPasswordEncoder()
                .username("author")
                .password("123")
                .roles("USER","AUTHOR")
                .build();
        return new InMemoryUserDetailsManager(admin,author);
    }

}
