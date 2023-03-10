package ru.otr.sf.widget.mapper.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.otr.sf.widget.model.UserWidget;

import java.io.Serializable;

/**
 * A DTO for the {@link UserWidget} entity
 */
@Getter
@Setter
public class UserWidgetDto implements Serializable {

    private Long id;
    private String userID;
    private WidgetDto widget;
    private Integer width;
    private Integer height;
    private Integer positionX;
    private Integer positionY;
    private Boolean show;
}