package com.lei.demo.service;

import com.lei.demo.domain.User;

import java.util.List;

/**
 * @author Chris
 */
public interface LoginService {
    List<User> verify(String userName, String password);
}
