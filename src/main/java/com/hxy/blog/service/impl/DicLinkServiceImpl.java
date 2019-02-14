package com.hxy.blog.service.impl;

import com.hxy.blog.dao.DicLinkMapper;
import com.hxy.blog.entity.DicLink;
import com.hxy.blog.service.DicLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DicLinkServiceImpl implements DicLinkService {

    @Autowired
    private DicLinkMapper dicLinkMapper;

    @Override
    public Integer saveLink(DicLink dicLink) {
        return dicLinkMapper.saveLink(dicLink);
    }

    @Override
    public Integer delLink(Long id) {
        return dicLinkMapper.delLink(id);
    }

    @Override
    public Integer updateLink(DicLink dicLink) {
        return dicLinkMapper.updateLink(dicLink);
    }

    @Override
    public DicLink findLink(Long id) {
        return dicLinkMapper.findLink(id);
    }

    @Override
    public List<DicLink> findLinkAll() {
        return dicLinkMapper.findLinkAll();
    }
}
