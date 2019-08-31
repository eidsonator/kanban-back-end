package com.eidsonator.kanban.mapper;

import com.eidsonator.kanban.model.Labels;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LabelMapper {
  // select labels.id, labels.description, color from labels join card_label cl on labels.id = cl.labelId join card c on cl.cardId = c.id where cardId =
    @Select("select labels.id, labels.description, color from labels join card_label cl on labels.id = cl.labelId join card c on cl.cardId = c.id where cl.cardId = #{cardId}")
    List<Labels> findForCard(long cardId);
}
