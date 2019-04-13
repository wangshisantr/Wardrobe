package com.xihua.wardrobe.mapper;

import com.xihua.wardrobe.pojo.Season;
import com.xihua.wardrobe.pojo.SeasonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeasonMapper {
    int countByExample(SeasonExample example);

    int deleteByExample(SeasonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Season record);

    int insertSelective(Season record);

    List<Season> selectByExample(SeasonExample example);

    Season selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Season record, @Param("example") SeasonExample example);

    int updateByExample(@Param("record") Season record, @Param("example") SeasonExample example);

    int updateByPrimaryKeySelective(Season record);

    int updateByPrimaryKey(Season record);
}