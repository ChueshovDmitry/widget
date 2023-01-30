package ru.otr.sf.widget.config;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

@KeycloakConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authManagerBuilder) {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        authManagerBuilder.authenticationProvider(keycloakAuthenticationProvider);
    }


    static class ModdedRequestMatcher implements RequestMatcher {

        private static final List<String> ALLOWED_ENDPOINTS = Collections.singletonList("api/");

        private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS|DELETE|POST|PUT|PATCH)$");
        private Pattern allowedEndpoints = Pattern.compile(
                String.format("^\\/(%s)$", StringUtils.arrayToDelimitedString(ALLOWED_ENDPOINTS.toArray(), "|")));

        public boolean matches(HttpServletRequest request) {
            String uri = request.getRequestURI().replaceFirst(request.getContextPath(), "");
            return !allowedEndpoints.matcher(uri).matches() && !allowedMethods.matcher(request.getMethod()).matches();
        }
    }
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().requireCsrfProtectionMatcher(new ModdedRequestMatcher()).and()
                //.csrf().disable()
                .authorizeRequests()
//                .antMatchers("api/**").authenticated()
                .antMatchers("/api/**", "/api/types/*",
                        "/api/user_widgets/*","/api/widgets/*").authenticated()
                .antMatchers("/auth/*", "/some/*").permitAll();
    }
    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

}
