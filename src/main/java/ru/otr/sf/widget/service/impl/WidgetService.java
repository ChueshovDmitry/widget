package ru.otr.sf.widget.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otr.sf.widget.mapper.WidgetMapper;
import ru.otr.sf.widget.mapper.dto.WidgetDto;
import ru.otr.sf.widget.model.Widget;
import ru.otr.sf.widget.repository.TypeRepository;
import ru.otr.sf.widget.repository.WidgetRepository;
import ru.otr.sf.widget.service.AbstractAuthUserService;
import ru.otr.sf.widget.service.AbstractWidgetService;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class WidgetService implements AbstractWidgetService {

    private final WidgetRepository widgetRepository;
    private final TypeRepository typeRepository;
    private final WidgetMapper widgetMapper;
    private final AbstractAuthUserService authUserService;

    @Override
    public WidgetDto save(WidgetDto widgetDto) {
        if (widgetRepository.existsWidgetByName(widgetDto.getName())) {
            Widget widgetByName = widgetRepository.getWidgetByName(widgetDto.getName());
            return widgetMapper.widgetToWidgetDto(widgetByName);
        } else {
            Widget widget = widgetRepository.save(widgetMapper.widgetDtoToWidget(widgetDto));
            return widgetMapper.widgetToWidgetDto(widget);
        }
    }

    @Override
    public void delete(Long id) {
        widgetRepository.deleteById(id);
    }

    @Override
    public List<WidgetDto> getAll() {
        List<Widget> widgets = widgetRepository.findAll();
        return widgets.stream().map(widgetMapper::widgetToWidgetDto).collect(Collectors.toList());
    }

    @Override
    public WidgetDto getById(Long id) {
        Widget referenceById = widgetRepository.getReferenceById(id);
        WidgetDto widgetDto = widgetMapper.widgetToWidgetDto(referenceById);
        return widgetDto;
    }

    @Override
    public List<WidgetDto> getAllWidgetByUserRole() {
        List<String> allWidgetNameByUserRole = authUserService.getAllWidgetNameByUserRole();
        List<Widget> allWidgetForUser = widgetRepository.findAllByNameIgnoreCaseIsIn(allWidgetNameByUserRole);
        return allWidgetForUser.stream().map(widgetMapper::widgetToWidgetDto).collect(Collectors.toList());
    }

    @Override
    public WidgetDto update(Long id, WidgetDto widgetDto) {
        Widget widget = widgetMapper.updateWidgetFromWidgetDto(widgetDto, widgetRepository.getReferenceById(id));
        return widgetMapper.widgetToWidgetDto(widgetRepository.save(widget));
    }
}




