package com.hxy.blog.service;

import com.hxy.blog.entity.DicLink;

import java.util.List;

public interface DicLinkService {

    Integer saveLink(DicLink dicLink);

    Integer delLink(Long id);

    Integer updateLink(DicLink dicLink);

    DicLink findLink(Long id);

    List<DicLink> findLinkAll();

}
