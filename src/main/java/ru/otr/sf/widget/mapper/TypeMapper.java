package ru.otr.sf.widget.mapper;

import org.mapstruct.*;
import ru.otr.sf.widget.mapper.dto.TypeDto;
import ru.otr.sf.widget.model.Type;
import ru.otr.sf.widget.model.Widget;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TypeMapper {

    Type typeDtoToType(TypeDto typeDto);

    TypeDto typeToTypeDto(Type type);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", source = "id", ignore = true)
    Type updateTypeFromTypeDto(TypeDto typeDto, @MappingTarget Type type);




}
