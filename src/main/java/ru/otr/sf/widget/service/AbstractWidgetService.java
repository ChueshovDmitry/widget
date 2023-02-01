package ru.otr.sf.widget.service;

import ru.otr.sf.widget.mapper.dto.WidgetDto;

import java.util.List;

public interface AbstractWidgetService {

    List<WidgetDto> getAllWidgetByUserRole();

    List<WidgetDto> getAllWidgetByUserRoleWithOutUserWidgets();

    List<WidgetDto> getAll();

    void delete(Long id);

    WidgetDto getById(Long id);

    WidgetDto save(WidgetDto widgetDto);

    WidgetDto update(Long id, WidgetDto widgetDto);
}
