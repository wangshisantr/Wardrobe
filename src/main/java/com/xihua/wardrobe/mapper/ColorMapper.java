package com.xihua.wardrobe.mapper;

import com.xihua.wardrobe.pojo.Color;
import com.xihua.wardrobe.pojo.ColorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ColorMapper {
    int countByExample(ColorExample example);

    int deleteByExample(ColorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Color record);

    int insertSelective(Color record);

    List<Color> selectByExample(ColorExample example);

    Color selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Color record, @Param("example") ColorExample example);

    int updateByExample(@Param("record") Color record, @Param("example") ColorExample example);

    int updateByPrimaryKeySelective(Color record);

    int updateByPrimaryKey(Color record);
}