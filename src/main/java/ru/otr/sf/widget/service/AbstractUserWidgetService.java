package ru.otr.sf.widget.service;

import ru.otr.sf.widget.mapper.dto.UserWidgetDto;

import java.util.List;

public interface AbstractUserWidgetService {

    List<UserWidgetDto> getAll();

    void delete(Long id);

    UserWidgetDto getById(Long id);

    UserWidgetDto save(UserWidgetDto userWidgetDto);

    UserWidgetDto update(Long id, UserWidgetDto userWidgetDto);

}
