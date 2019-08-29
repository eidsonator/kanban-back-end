package com.eidsonator.kanban.mapper;

import com.eidsonator.kanban.model.KanbanList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface KanbanListMapper {
    @Select("SELECT id, title, added_timestamp FROM kanban.list")
    List<KanbanList> findAll();

}
