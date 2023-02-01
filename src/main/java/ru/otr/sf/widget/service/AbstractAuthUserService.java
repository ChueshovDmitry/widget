package ru.otr.sf.widget.service;

import org.keycloak.KeycloakPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.otr.sf.widget.mapper.dto.UserDto;

import java.util.List;

public interface AbstractAuthUserService {

    List<String> getAllRolesFromGrandAuthority();

    List<String> getAllWidgetNameByUserRole();

    String getUserUUID();

    UserDto getUserFullName();

    default KeycloakPrincipal getPrincipal(){
        return (KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
