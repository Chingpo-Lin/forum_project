package net.project.forum.service.impl;

import net.project.forum.dao.CategoryDao;
import net.project.forum.domain.Category;
import net.project.forum.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDao();

    @Override
    public List<Category> list() {
        return categoryDao.list();
    }
}
