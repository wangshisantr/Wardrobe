package com.xihua.wardrobe.mapper;

import com.xihua.wardrobe.pojo.Collocation;
import com.xihua.wardrobe.pojo.CollocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollocationMapper {
    int countByExample(CollocationExample example);

    int deleteByExample(CollocationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Collocation record);

    int insertSelective(Collocation record);

    List<Collocation> selectByExample(CollocationExample example);

    Collocation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Collocation record, @Param("example") CollocationExample example);

    int updateByExample(@Param("record") Collocation record, @Param("example") CollocationExample example);

    int updateByPrimaryKeySelective(Collocation record);

    int updateByPrimaryKey(Collocation record);
}