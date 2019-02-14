package com.hxy.blog.dao;

import com.hxy.blog.entity.DicLink;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 友链的添加删除修改
 */

@Mapper
public interface DicLinkMapper {

    Integer saveLink(DicLink dicLink);

    Integer delLink(Long id);

    Integer updateLink(DicLink dicLink);

    DicLink findLink(Long id);

    List<DicLink> findLinkAll();


}
