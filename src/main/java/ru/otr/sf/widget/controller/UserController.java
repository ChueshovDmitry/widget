package ru.otr.sf.widget.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otr.sf.widget.mapper.dto.UserDto;
import ru.otr.sf.widget.service.AbstractAuthUserService;


@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final AbstractAuthUserService authUserService;

     @GetMapping
    public UserDto getUserFullName(){
        return authUserService.getUserFullName();
    }

}
