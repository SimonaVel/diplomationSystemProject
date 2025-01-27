package com.project.diplomation.config;
import com.project.diplomation.service.UserService;
import jakarta.servlet.DispatcherType;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
//        prePostEnabled = true,
        securedEnabled = true
)
@AllArgsConstructor
public class SecurityConfig {
    private final UserService userService;

//    @Bean
//    public InMemoryUserDetailsManager userDetailsInMemory() {
//        UserDetails user1 = User
//                .withUsername("user")
//                .password(passwordEncoder().encode("123456"))
//                .build();
//        UserDetails user2 = User
//                .withUsername("admin")
//                .password(passwordEncoder().encode("123456"))
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
    @Bean
    public JwtDecoder jwtDecoder() {
        String issuerUri = "http://127.0.0.1:8080/realms/diplomation-realm";
        return JwtDecoders.fromIssuerLocation(issuerUri);
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakAuthorityConverter());
        return jwtAuthenticationConverter;
    }

//    Can you allow all requests withouth authentication?
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests
                        (authz -> authz
                                .anyRequest()
                                        .permitAll()
                        )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwtCustomizer -> jwtCustomizer
                                .jwtAuthenticationConverter(jwtAuthenticationConverter())))
                .oauth2Login(Customizer.withDefaults());
        return http.build();
    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests
//                        (authz -> authz
////                                .requestMatchers("/students/*").hasAuthority("tutor")
////                                .requestMatchers("/uni-tutors/*").hasAuthority("tutor")
////                                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
////                                        .requestMatchers("/***").permitAll()
//
//                                .anyRequest()
//                                        .permitAll()
////                                        .authenticated()
//                        )
//                .oauth2ResourceServer(oauth2 -> oauth2
//                        .jwt(jwtCustomizer -> jwtCustomizer
//                                .jwtAuthenticationConverter(jwtAuthenticationConverter())))
//                .oauth2Login(Customizer.withDefaults());
//        return http.build();
//    }
}
