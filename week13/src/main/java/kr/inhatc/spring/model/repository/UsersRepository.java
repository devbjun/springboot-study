package kr.inhatc.spring.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.model.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
  List<Users> findAllByOrderByIdDesc();
  Optional<Users> findByAccount(String account);
}