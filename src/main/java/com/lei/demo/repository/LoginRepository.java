package com.lei.demo.repository;

import com.lei.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Chris
 */
public interface LoginRepository extends JpaRepository<User, Integer> {

    List<User> findByUserNameAndPassword(String userName, String password);
}
