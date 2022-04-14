package net.project.forum.controller;

import net.project.forum.domain.User;
import net.project.forum.service.UserService;
import net.project.forum.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "userServlet", urlPatterns = {"/user"})
public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();

    public void login(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");

        User user = userService.login(phone, pwd);
        if (user != null) {
            request.getSession().setAttribute("loginUser", user);
        } else {
            request.setAttribute("msg", "用户名或者密码错误");
        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().invalidate();
        // 页面跳转
    }

    public void register(HttpServletRequest req, HttpServletResponse response) {
        User user = new User();
        Map<String, String[]> map = req.getParameterMap();

        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        int i = userService.register(user);
        if (i > 0) {
            // success register, forward to login page
        } else {
            // fail, forward to regist page
        }
    }
}
