package ru.otr.sf.widget.mapper.dto;

import lombok.Getter;
import lombok.Setter;
import ru.otr.sf.widget.model.Widget;

import java.io.Serializable;

/**
 * A DTO for the {@link Widget} entity
 */
@Getter
@Setter
public class WidgetDto implements Serializable {

    private Long id;
    private String name;
    private String url;
    private String actionUrl;
    private String description;
    private String defaultWidth;
    private String defaultHeight;

}