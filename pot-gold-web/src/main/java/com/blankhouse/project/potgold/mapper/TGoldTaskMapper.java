package com.blankhouse.project.potgold.mapper;

import com.blankhouse.project.potgold.model.TGoldTask;
import com.blankhouse.project.potgold.model.TGoldTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGoldTaskMapper {
    int countByExample(TGoldTaskExample example);

    int deleteByExample(TGoldTaskExample example);

    int insert(TGoldTask record);

    int insertSelective(TGoldTask record);

    List<TGoldTask> selectByExampleWithBLOBs(TGoldTaskExample example);

    List<TGoldTask> selectByExample(TGoldTaskExample example);

    int updateByExampleSelective(@Param("record") TGoldTask record, @Param("example") TGoldTaskExample example);

    int updateByExampleWithBLOBs(@Param("record") TGoldTask record, @Param("example") TGoldTaskExample example);

    int updateByExample(@Param("record") TGoldTask record, @Param("example") TGoldTaskExample example);
}