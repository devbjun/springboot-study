package kr.inhatc.spring.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.model.entity.Users;
import kr.inhatc.spring.model.repository.UsersRepository;
import kr.inhatc.spring.model.security.SecurityUsers;

@Service
public class SecurityUserDetailService implements UserDetailsService {

  @Autowired
  private UsersRepository usersRepository;

  @Override
  public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
    Optional<Users> optional = usersRepository.findByAccount(account);

    if (optional.isPresent()) {
      Users user = optional.get();
      return new SecurityUsers(user);
    }
    
    throw new UsernameNotFoundException(account + " 사용자 없음");
  }
}