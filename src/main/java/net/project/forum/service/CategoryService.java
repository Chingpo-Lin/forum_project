package net.project.forum.service;

import net.project.forum.domain.Category;

import java.util.List;


public interface CategoryService {
    /**
     * 全部分类
     * @return
     */
    List<Category> list();
}
