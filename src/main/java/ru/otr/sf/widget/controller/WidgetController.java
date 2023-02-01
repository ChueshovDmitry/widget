package ru.otr.sf.widget.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ru.otr.sf.widget.mapper.dto.WidgetDto;
import ru.otr.sf.widget.service.AbstractWidgetService;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("api/widgets")
@RequiredArgsConstructor
public class WidgetController {

    private final AbstractWidgetService abstractWidgetService;

    @GetMapping()
    public List<WidgetDto> getWidgets(){
        return abstractWidgetService.getAll();
    }

    @GetMapping("/roles")
    public List<WidgetDto> getWidgetsByUserRoles(){
        return abstractWidgetService.getAllWidgetByUserRole();
    }
    @GetMapping("/withOutUserWidgets")
    public List<WidgetDto> getAllWidgetByUserRoleWithOutUserWidgets(){
        return abstractWidgetService.getAllWidgetByUserRoleWithOutUserWidgets();
    }
    @GetMapping("/{id}")
    public WidgetDto getWidget(@PathVariable Long id){
        return abstractWidgetService.getById(id);
    }

    @PostMapping()
    public WidgetDto saveWidget(@RequestBody WidgetDto widgetDto){
        return abstractWidgetService.save(widgetDto);
    }

    @DeleteMapping("/{id}")
    public void deleteWidget(@PathVariable Long id){
        abstractWidgetService.delete(id);
    }

    @PatchMapping("/{id}")
    public WidgetDto updateWidget(@PathVariable Long id, @RequestBody WidgetDto widgetDto){
         return abstractWidgetService.update(id, widgetDto);
    }

}
