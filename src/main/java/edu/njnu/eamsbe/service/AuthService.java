package edu.njnu.eamsbe.service;

import edu.njnu.eamsbe.pojo.entity.User;

import java.util.List;

public interface AuthService {
    boolean login(User user);
    boolean register(User user);
}
