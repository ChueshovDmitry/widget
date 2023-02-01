package ru.otr.sf.widget.mapper;

import org.mapstruct.*;
import ru.otr.sf.widget.mapper.dto.WidgetDto;
import ru.otr.sf.widget.model.Widget;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WidgetMapper {

    Widget widgetDtoToWidget(WidgetDto widgetDto);

    WidgetDto widgetToWidgetDto(Widget widget);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", source = "id", ignore = true)
    Widget updateWidgetFromWidgetDto(WidgetDto widgetDto, @MappingTarget Widget widget);
}
