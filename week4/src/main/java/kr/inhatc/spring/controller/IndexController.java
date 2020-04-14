package kr.inhatc.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.inhatc.spring.model.User;
import kr.inhatc.spring.model.service.UserService;

@Controller
public class IndexController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/")
  public String thymeleafIndex(Model model) {

    List<User> userList = userService.selectUser();
    model.addAttribute("list", userList);

    return "index";
  }

  /*@RequestMapping("/")
  public ModelAndView index() throws Exception {
    ModelAndView mav = new ModelAndView("index");

    mav.addObject("name", "201445049 박정준");

    return mav;
  }*/
}