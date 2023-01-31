package ru.otr.sf.widget.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "user_widget")
public class UserWidget {
    /**
     * id c помощь auto-increment колонку в таблице
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * id пользователя
     */
    @Column(name = "user_id")
    private String userID;

    /**
     * id виджета
     */
    @ManyToOne
    @JoinColumn(name = "widget_id")
    private Widget widget;

    /**
     * ширина по умолчанию
     */
    @Column(name = "width")
    private Integer width;
    /**
     * высота по умолчанию
     */
    @Column(name = "height")
    private Integer height;
    /**
     * значение позиции по x
     */
    @Column(name = "position_x")
    private String positionX;
    /**
     * значение позиции по y
     */
    @Column(name = "position_y")
    private String positionY;

    /**
     * флг отображения виджета
     */
    @Column(name = "show")
    private Boolean show;

    /**
     * тип виджета
     */
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

}