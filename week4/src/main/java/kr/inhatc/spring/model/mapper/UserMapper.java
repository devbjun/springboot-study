package kr.inhatc.spring.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.model.User;

@Repository
@Mapper
public interface UserMapper {
  List<User> selectUser();
}