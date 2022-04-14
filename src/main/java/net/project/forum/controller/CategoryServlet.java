package net.project.forum.controller;

import net.project.forum.domain.Category;
import net.project.forum.service.CategoryService;
import net.project.forum.service.impl.CategoryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "categoryServlet", urlPatterns = {"/category"})
public class CategoryServlet extends BaseServlet{

    private CategoryService categoryService = new CategoryServiceImpl();

    /**
     * 返回全部分类
     */
    public void list(HttpServletRequest req, HttpServletResponse resp) {
        List<Category> list = categoryService.list();
        req.setAttribute("categoryList", list);
        System.out.println(list.toString());
    }
}
