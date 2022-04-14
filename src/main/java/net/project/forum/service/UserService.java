package net.project.forum.service;

import net.project.forum.domain.User;

public interface UserService {

    int register(User user);

    User login(String phone, String pwd);
}
