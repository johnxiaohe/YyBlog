package com.hxy.blog.service.impl;

import com.hxy.blog.dao.DicCatgoryMapper;
import com.hxy.blog.entity.DicCatgory;
import com.hxy.blog.service.DicCatgoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DicCatgoryServiceImpl implements DicCatgoryService {
    @Autowired
    private DicCatgoryMapper dicCatgoryMapper;

    @Override
    public Long saveCatgory(DicCatgory dicCatgory) {
        return dicCatgoryMapper.saveCatgory(dicCatgory);
    }

    @Override
    public void delCatgory(Long id) {
         dicCatgoryMapper.delCatgory(id);
    }

    @Override
    public Integer updateCatgory(DicCatgory dicCatgory) {
        return dicCatgoryMapper.updateCatgory(dicCatgory);
    }

    @Override
    public List<DicCatgory> findCatgory() {
        return dicCatgoryMapper.findCatgory();
    }

    @Override
    public List<DicCatgory> findCatgoryNum() {
        return dicCatgoryMapper.findCatgoryNum();
    }

    @Override
    public DicCatgory findCategoryById(Integer id) {
        return dicCatgoryMapper.findCategoryById(id);
    }
}
