package ru.otr.sf.widget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otr.sf.widget.model.Widget;

import java.util.List;

public interface WidgetRepository extends JpaRepository<Widget, Long> {


    Boolean existsWidgetByName(String name);

    Widget getWidgetByName(String name);

    List<Widget> findAllByNameIgnoreCaseIsIn(List<String>name);


}