package com.eidsonator.kanban.mapper;

import com.eidsonator.kanban.model.Card;
import com.eidsonator.kanban.model.CardLabelLookUp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface CardLabelLookUpMapper {
    @Select("SELECT  FROM card_label WHERE listId = #{parent}")
    List<CardLabelLookUp> findAll(long parent);
}
