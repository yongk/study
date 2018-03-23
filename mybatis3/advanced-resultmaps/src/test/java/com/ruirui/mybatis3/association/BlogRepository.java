package com.ruirui.mybatis3.association;

import java.util.List;

public interface BlogRepository {
    List<Blog> findAllNestedResult();

    List<Blog> findAllNestedResultApplyNotNullColumn();

    Blog selectBlogByIdEager(int id);

    Blog selectBlogByIdLazy(int id);

    List<Blog> selectBlogsEager();

    List<Blog> selectBlogsLazy();
}
