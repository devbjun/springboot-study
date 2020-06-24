package kr.inhatc.spring.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import groovy.util.logging.Slf4j;

@Controller
@Slf4j
public class LoginController {
  
  @GetMapping("/login/login")
  public void login() {}

  @GetMapping("/login/accessDenied")
  public void accessDenied() {}

  @GetMapping("/login/logout")
  public void logout() {}

}