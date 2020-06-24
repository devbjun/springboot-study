package kr.inhatc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  @RequestMapping(value = "/")
  public String thymeleafIndex(Model model) {
    return "index";
  }
}