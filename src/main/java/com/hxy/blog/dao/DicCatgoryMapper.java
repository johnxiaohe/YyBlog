package com.hxy.blog.dao;

import com.hxy.blog.entity.DicCatgory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 分类dao   实现分类的增加、删除、修改、查找
 */
@Mapper
public interface DicCatgoryMapper {
    //增加分类  返回分类的ID
    Long saveCatgory(DicCatgory dicCatgory);

    //删除分类 返回影响的行数 返回0表示没有成功
    void delCatgory(Long id);

    //修改分类信息
    Integer updateCatgory(DicCatgory dicCatgory);

    //查找分类
    List<DicCatgory> findCatgory();

    //分类下博客数量
//select dic_catgory.* , sf.num from dic_catgory left join (select categoryId , COUNT(categoryId) num from h_blog GROUP BY categoryId) sf on dic_catgory.id = sf.categoryId
    List<DicCatgory> findCatgoryNum();

    DicCatgory findCategoryById(@Param(value = "id")Integer  id);


}
