package com.hxy.blog.service.impl;

import com.hxy.blog.dao.DicTagMapper;
import com.hxy.blog.entity.DicTag;
import com.hxy.blog.service.DicTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DicTagServiceImpl implements DicTagService {

    @Autowired
    private DicTagMapper dicTagMapper;

    @Override
    public Integer saveTag(DicTag dicTag) {
        return dicTagMapper.saveTag(dicTag);
    }

    @Override
    public Integer delTag(Long id) {
        return dicTagMapper.delTag(id);
    }

    @Override
    public Integer updateTag(DicTag dicTag) {
        return dicTagMapper.updateTag(dicTag);
    }

    @Override
    public List<DicTag> findTagAll() {
        return dicTagMapper.findTagAll();
    }

    @Override
    public List<DicTag> findTagByTags(String[] tags) {
        return dicTagMapper.findTagByTags(tags);
    }
}
