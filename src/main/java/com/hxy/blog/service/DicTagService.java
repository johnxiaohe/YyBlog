package com.hxy.blog.service;

import com.hxy.blog.entity.DicTag;

import java.util.List;

public interface DicTagService {

    Integer saveTag(DicTag dicTag);

    Integer delTag(Long id);

    Integer updateTag(DicTag dicTag);

    List<DicTag> findTagAll();

    List<DicTag> findTagByTags(String[] tags);

}
