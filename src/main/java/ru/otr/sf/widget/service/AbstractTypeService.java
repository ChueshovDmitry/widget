package ru.otr.sf.widget.service;

import ru.otr.sf.widget.mapper.dto.TypeDto;

import java.util.List;

public interface AbstractTypeService {

    List<TypeDto> getAll();

    void delete(Long id);

    TypeDto getById(Long id);

    TypeDto save(TypeDto typeDto);

    TypeDto update(TypeDto typeDto);
}
