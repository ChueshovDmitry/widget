package ru.otr.sf.widget.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otr.sf.widget.mapper.UserWidgetMapper;
import ru.otr.sf.widget.mapper.dto.UserWidgetDto;
import ru.otr.sf.widget.model.UserWidget;
import ru.otr.sf.widget.model.Widget;
import ru.otr.sf.widget.repository.UserWidgetRepository;
import ru.otr.sf.widget.repository.WidgetRepository;
import ru.otr.sf.widget.service.AbstractAuthUserService;
import ru.otr.sf.widget.service.AbstractUserWidgetService;
import ru.otr.sf.widget.service.AbstractWidgetService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserWidgetService implements AbstractUserWidgetService {

    private final UserWidgetRepository userWidgetRepository;
    private final UserWidgetMapper userWidgetMapper;
    private final WidgetRepository widgetRepository;
    private final AbstractAuthUserService authUserService;

    @Override
    public UserWidgetDto save(UserWidgetDto userWidgetDto) {
        if (userWidgetRepository.existsUserWidgetByUserIDAndWidgetId(authUserService.getUserUUID(), userWidgetDto.getWidget().getId())) {
            UserWidget userWidgetByUserIDAndWidgetId = userWidgetRepository.getUserWidgetByUserIDAndWidgetId(authUserService.getUserUUID(), userWidgetDto.getWidget().getId());
            return userWidgetMapper.userWidgetToUserWidgetDto(userWidgetByUserIDAndWidgetId);
        } else {
            UserWidget userWidget2 = userWidgetMapper.userWidgetDtoToUserWidget(userWidgetDto);
            userWidget2.setUserID(authUserService.getUserUUID());
            return userWidgetMapper.userWidgetToUserWidgetDto(userWidgetRepository.save(userWidget2));
        }
    }

    @Override
    public void delete(Long id) {
        userWidgetRepository.deleteById(id);
    }

    @Override
    public List<UserWidgetDto> getAll() {
        Stream<UserWidgetDto> userWidgetDtoStream = userWidgetRepository.findAll().stream().map(userWidgetMapper::userWidgetToUserWidgetDto);
        return userWidgetDtoStream.collect(Collectors.toList());
    }

    @Override
    public UserWidgetDto getById(Long id) {
        return userWidgetMapper.userWidgetToUserWidgetDto(userWidgetRepository.getReferenceById(id));
    }

    @Override
    public UserWidgetDto update(Long id, UserWidgetDto userWidgetDto) {
        UserWidget userWidget = userWidgetMapper.updateUserWidgetFromUserWidgetDto(userWidgetDto, userWidgetRepository.getReferenceById(id));
        userWidget.setWidget(widgetRepository.getReferenceById(userWidgetDto.getWidget().getId()));
        return userWidgetMapper.userWidgetToUserWidgetDto(userWidgetRepository.save(userWidget));
    }
}
