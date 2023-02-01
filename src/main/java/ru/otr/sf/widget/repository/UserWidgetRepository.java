package ru.otr.sf.widget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otr.sf.widget.model.UserWidget;

import java.util.List;

public interface UserWidgetRepository extends JpaRepository<UserWidget, Long> {

    Boolean existsUserWidgetByUserIDAndWidgetId(String name, Long widgetId);

    UserWidget getUserWidgetByUserIDAndWidgetId(String name, Long widgetId);

    List<UserWidget> findAllByUserID(String id);
}