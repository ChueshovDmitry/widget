package ru.otr.sf.widget.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ru.otr.sf.widget.mapper.dto.UserWidgetDto;
import ru.otr.sf.widget.mapper.dto.WidgetDto;
import ru.otr.sf.widget.service.AbstractUserWidgetService;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("api/user_widgets")
@RequiredArgsConstructor
public class UserWidgetController {

    private final AbstractUserWidgetService abstractUserWidgetService;

    @GetMapping()
    public List<UserWidgetDto> getUserWidgets(){
        return abstractUserWidgetService.getAll();
    }

    @GetMapping("/{id}")
    public UserWidgetDto getUserWidget(@PathVariable Long id){
        return abstractUserWidgetService.getById(id);
    }

    @PostMapping()
    public UserWidgetDto saveUserWidget(@RequestBody UserWidgetDto userWidgetDto){
        return abstractUserWidgetService.save(userWidgetDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUserWidget(@PathVariable Long id){
        abstractUserWidgetService.delete(id);
    }

    @PatchMapping("/{id}")
    public UserWidgetDto updateUserWidget(@PathVariable Long id, @RequestBody UserWidgetDto userWidgetDto){
        return abstractUserWidgetService.update(id, userWidgetDto);

    }

}
