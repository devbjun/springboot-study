package kr.inhatc.spring.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.model.User;
import kr.inhatc.spring.model.mapper.UserMapper;

@Service
public class UserService {

  @Autowired
  public UserMapper mapper;

  public List<User> selectUser() {
    return mapper.selectUser();
  }
}