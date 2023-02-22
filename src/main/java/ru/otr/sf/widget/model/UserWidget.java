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
    @Column(name = "position")
    private Integer position;

    @Column(name = "line")
    private Integer line;

    @Column(name = "line_height")
    private Integer lineHeight;

    /**
     * тип виджета
     */
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

}