package ru.otr.sf.widget.mapper.dto;

import lombok.*;
import ru.otr.sf.widget.model.Type;

import java.io.Serializable;

/**
 * A DTO for the {@link Type} entity
 */
@Getter
@Setter
public class TypeDto implements Serializable {

    private Long id;
    private String name;
    private String width;
    private String height;
}