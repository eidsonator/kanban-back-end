package com.eidsonator.kanban.mapper;

import com.eidsonator.kanban.model.Task;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TaskMapper {
    @Select("SELECT id, title, description, parent, status FROM task WHERE parent is null")
    List<Task> findAll();

    @Select("SELECT id, title, description, parent, status FROM task WHERE parent = ${parentId}")
    List<Task> findChildren(long parentId);

    @Insert("INSERT INTO task (title, description, parent) values(#{title}, #{description}, #{parent})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Task task);

    @Update("UPDATE task set title = #{title}, description = #{description}, parent = #{parent} where id = #{id}")
    void update(Task task);

    @Delete("DELETE FROM task WHERE id = #{id}")
    void delete(long id);
}
