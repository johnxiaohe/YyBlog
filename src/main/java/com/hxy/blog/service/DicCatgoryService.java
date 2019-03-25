package com.hxy.blog.service;


import com.hxy.blog.entity.DicCatgory;

import java.util.List;

public interface DicCatgoryService {

    Long saveCatgory(DicCatgory dicCatgory);

    void delCatgory(Long id);
    Integer updateCatgory(DicCatgory dicCatgory);
    List<DicCatgory> findCatgory();
    List<DicCatgory> findCatgoryNum();
    DicCatgory findCategoryById(Integer id);
}
