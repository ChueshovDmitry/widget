package ru.otr.sf.widget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otr.sf.widget.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {

    Boolean existsTypeByName(String name);

    Type getTypeByName(String name);


}