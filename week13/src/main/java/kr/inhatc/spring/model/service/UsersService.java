package kr.inhatc.spring.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.model.entity.Users;
import kr.inhatc.spring.model.repository.UsersRepository;

@Service
public class UsersService {

  @Autowired
  UsersRepository usersRepository;

  public List<Users> usersList() {
    List<Users> list = usersRepository.findAllByOrderByIdDesc();
    return list;
  }

  public void saveUsers(Users user) {
    usersRepository.save(user);
  }

  public Users userDetail(Long id) {
    Optional<Users> optional = usersRepository.findById(id);

    if (optional.isPresent()) {
      Users user = optional.get();
      return user;
    }

    throw new NullPointerException();
  }

  public void deleteUser(Long id) {
    usersRepository.deleteById(id);
  }
  
}