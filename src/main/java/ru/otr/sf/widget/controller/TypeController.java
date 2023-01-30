package ru.otr.sf.widget.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otr.sf.widget.mapper.dto.TypeDto;
import ru.otr.sf.widget.service.AbstractTypeService;

import java.util.List;

@RestController
@RequestMapping("api/types")
@RequiredArgsConstructor
public class TypeController {

    private final AbstractTypeService abstractTypeService;

    @GetMapping()
    public List<TypeDto> getTypes(){
        return abstractTypeService.getAll();
    }

    @GetMapping("/{id}")
    public TypeDto getTypeByID(@PathVariable Long id){
        return abstractTypeService.getById(id);
    }

    @PostMapping("/type")
    public TypeDto saveType(@RequestBody TypeDto typeDto){
        return abstractTypeService.save(typeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTypeById(@PathVariable Long id){
        abstractTypeService.delete(id);
    }


    @PatchMapping
    public TypeDto updateType(@RequestBody TypeDto typeDto){
       return abstractTypeService.update(typeDto);
    }
}
