package com.lei.demo.serviceImpl;

import com.lei.demo.repository.LoginRepository;
import com.lei.demo.domain.User;
import com.lei.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chris
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository userRepository;

    /**
     * @Author: Chris
     * @Date: 10:57 2018/6/19
     * @Description: 从数据库查询用户
     * @params:
     * * @param userName
     * * @param password
     */
    @Override
    public List<User> verify(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password);
    }

}
