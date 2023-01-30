package ru.otr.sf.widget.service.impl;

import org.keycloak.KeycloakPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.otr.sf.widget.service.AbstractAuthUserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthUserService implements AbstractAuthUserService {

    @Override
    public List<String> getAllRolesFromGrandAuthority(){
        return SecurityContextHolder.
                getContext().
                getAuthentication().
                getAuthorities().stream().map(grantedAuthority -> grantedAuthority.getAuthority()).collect(Collectors.toList());
    }
    @Override
    public List<String> getAllWidgetNameByUserRole(){
        return getAllRolesFromGrandAuthority().stream().
                filter(s -> s.contains("ROLE_WIDGET_")).
                map(s -> s.replace("ROLE_WIDGET_", ""))
                .collect(Collectors.toList());
    }
    @Override
    public String getUserUUID() {
        KeycloakPrincipal principal = (KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userId = principal.getKeycloakSecurityContext().getToken().getSubject();
        return userId;
    }
}
