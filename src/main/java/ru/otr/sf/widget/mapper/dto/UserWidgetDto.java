package ru.otr.sf.widget.mapper.dto;

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
    private String width;
    private String height;
    private String positionX;
    private String positionY;
    private Boolean show;
    private TypeDto type;
}