package ru.otr.sf.widget.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "widget")
public class Widget {

    /**
     * id c помощь auto-increment колонку в таблице
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * наименование виджета
     */
    @Column(name = "name")
    private String name;

    /**
     * url
     */
    @Column(name = "url")
    private String url;

    /**
     * описание виджета
     */
    @Column(name = "description")
    private String description;

    /**
     * ширина по умолчанию
     */
    @Column(name = "defaul_width")
    private Integer defaultWidth;

    /**
     * ширина по высота по умолчанию
     */
    @Column(name = "defaul_height")
    private Integer defaultHeight;

    /**
     * тип виджета
     */
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

}