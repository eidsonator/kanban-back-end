package com.eidsonator.kanban.mapper;

import com.eidsonator.kanban.model.Card;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CardMapper {
    @Select("SELECT id, title, description, listId, added_timestamp FROM card WHERE listId = #{parent}")
    List<Card> findAll(long parent);
}
