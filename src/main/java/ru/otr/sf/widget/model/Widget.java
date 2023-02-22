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
     * action url
     */
    @Column(name = "action_url")
    private String actionUrl;

    /**
     * описание виджета
     */
    @Column(name = "description")
    private String description;




}