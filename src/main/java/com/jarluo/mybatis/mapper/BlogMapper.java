package com.jarluo.mybatis.mapper;

import com.jarluo.mybatis.Blog;

/**
 * @from: https://www.cnblogs.com/java333/
 * @desc: TODO
 * @author: jar luo
 * @date: 2019/7/16 20:57
 */
public interface BlogMapper {
    /**
     * @desc 根据主键查询文章
     * @param id
     * @return
     */
    public Blog selectBlogById(Integer id);
}
