package com.xihua.wardrobe.mapper;

import com.xihua.wardrobe.pojo.Clothes;
import com.xihua.wardrobe.pojo.ClothesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClothesMapper {
    int countByExample(ClothesExample example);

    int deleteByExample(ClothesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Clothes record);

    int insertSelective(Clothes record);

    List<Clothes> selectByExample(ClothesExample example);

    Clothes selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Clothes record, @Param("example") ClothesExample example);

    int updateByExample(@Param("record") Clothes record, @Param("example") ClothesExample example);

    int updateByPrimaryKeySelective(Clothes record);

    int updateByPrimaryKey(Clothes record);
}