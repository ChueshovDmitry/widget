package ru.otr.sf.widget.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "type_widget")
public class Type {
    /**
     * id c помощь auto-increment колонку в таблице
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * наименование типа
     */
    @Column(name = "name")
    private String name;

    /**
     * ширина
     */
    @Column(name = "width")
    private String width;

    /**
     * высота
     */
    @Column(name = "height")
    private String height;


}