package ru.otr.sf.widget.service;

import java.util.List;

public interface AbstractAuthUserService {

    List<String> getAllRolesFromGrandAuthority();

    List<String> getAllWidgetNameByUserRole();

    String getUserUUID();
}
