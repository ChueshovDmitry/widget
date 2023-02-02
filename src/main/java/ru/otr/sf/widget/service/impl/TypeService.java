package ru.otr.sf.widget.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otr.sf.widget.mapper.TypeMapper;
import ru.otr.sf.widget.mapper.dto.TypeDto;
import ru.otr.sf.widget.model.Type;
import ru.otr.sf.widget.repository.TypeRepository;
import ru.otr.sf.widget.service.AbstractTypeService;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TypeService implements AbstractTypeService {

    private final TypeRepository typeRepository;
    private final TypeMapper typeMapper;

    @Override
    public TypeDto save(TypeDto typeDto) {
        if (typeRepository.existsTypeByName(typeDto.getName())) {
            Type typeByName = typeRepository.getTypeByName(typeDto.getName());
            return typeMapper.typeToTypeDto(typeByName);
        } else {
            return typeMapper.typeToTypeDto(typeRepository.save(typeMapper.typeDtoToType(typeDto)));
        }
    }

    @Override
    public void delete(Long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public List<TypeDto> getAll() {
        List<Type> all = typeRepository.findAll();
        return all.stream().map(typeMapper::typeToTypeDto).collect(Collectors.toList());
    }

    @Override
    public TypeDto getById(Long id) {
        return typeMapper.typeToTypeDto(typeRepository.getReferenceById(id));
    }

    @Override
    public TypeDto update(Long id, TypeDto typeDto) {
        Type type = typeMapper.updateTypeFromTypeDto(typeDto, typeRepository.getReferenceById(id));
        return typeMapper.typeToTypeDto(typeRepository.save(type));
    }
}




