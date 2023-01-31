package ru.otr.sf.widget.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import ru.otr.sf.widget.service.AbstractAuthUserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AuthUserServiceTest {

    @SpyBean
    AbstractAuthUserService authUserService;


    @Test
    void getAllRolesFromGrandAuthority() {

        List<String> inspectedList = List.of("ROLE_KC_WIDGET_ONE", "ROLE_KC_WIDGET_two", "ROdLE_KC_WIDGET_two");

        doReturn(inspectedList).when(authUserService).getAllRolesFromGrandAuthority();

        assertNotNull(authUserService.getAllWidgetNameByUserRole());
        assertInstanceOf(List.class, authUserService.getAllWidgetNameByUserRole());
        assertEquals(2, authUserService.getAllWidgetNameByUserRole().size());
    }
}