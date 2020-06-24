package kr.inhatc.spring.model.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import kr.inhatc.spring.model.entity.Users;

@SuppressWarnings("serial")
public class SecurityUsers extends User {

  private Users user;

  public SecurityUsers(Users user) {
    super(user.getAccount(), (user.getPassword().contains("{bcrypt}") ? "" : "{noop}") +  user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole()));
    this.user = user;
  }
  
}