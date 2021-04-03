package com.example.wbdvsp2103FurongTianserverjava.repositories;

import com.example.wbdvsp2103FurongTianserverjava.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository
    // specific: store, data type of primary key
extends CrudRepository<Widget, Long> {
    @Query(value = "SELECT * FROM widgets WHERE topic_id=:tid", nativeQuery = true)
    public List<Widget> findWidgetsForTopic(@Param("tid") String topicId);
}
