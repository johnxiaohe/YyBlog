package com.hxy.blog.dao;

import com.hxy.blog.entity.DicTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 标签的添加、查找、修改
 */

@Mapper
public interface DicTagMapper {

    Integer saveTag(DicTag dicTag);

    Integer delTag(Long id);

    Integer updateTag(DicTag dicTag);

    List<DicTag> findTagAll();

    List<DicTag> findTagByTags(String[] tags);

}
