package ru.otr.sf.widget.mapper;

import org.mapstruct.*;
import ru.otr.sf.widget.mapper.dto.UserWidgetDto;
import ru.otr.sf.widget.model.UserWidget;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserWidgetMapper {

    @Mapping(target = "userID", source = "userID", ignore = true)
    UserWidget userWidgetDtoToUserWidget(UserWidgetDto userWidgetDto);

    UserWidgetDto userWidgetToUserWidgetDto(UserWidget userWidget);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id",source = "id",ignore = true)
    @Mapping(target = "widget",source = "widget",ignore = true)
    @Mapping(target = "type",source = "type",ignore = true)
    UserWidget updateUserWidgetFromUserWidgetDto(UserWidgetDto userWidgetDto, @MappingTarget UserWidget userWidget);
}
