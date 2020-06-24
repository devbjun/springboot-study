package kr.inhatc.spring.controller.users;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.model.entity.Users;
import kr.inhatc.spring.model.service.UsersService;

@Controller
public class UsersController {
  
  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private UsersService usersService;

  @RequestMapping(value = "/user/userList", method = RequestMethod.GET)
  public String userList(Model model) {
    List<Users> usersList = usersService.usersList();
    model.addAttribute("list", usersList);

    log.debug("=======> " + usersList.size());
    return "user/userList";
  }

  @RequestMapping(value = "/user/userInsert", method = RequestMethod.GET)
  public String userWrite() {
    return "user/userWrite";
  }

  @RequestMapping(value = "/user/userInsert", method = RequestMethod.POST)
  public String userInsert(Users user) {
    log.debug("=======> " + user);

    user.setEnabled(true);
    usersService.saveUsers(user);
    return "redirect:/user/userList";
  }

  @RequestMapping(value = "/user/userDetail/{id}", method = RequestMethod.GET)
  public String userDetail(@PathVariable("id") Long id, Model model) {
    Users user = usersService.userDetail(id);
    
    model.addAttribute("user", user);
    return "user/userDetail";
  }

  @RequestMapping(value = "/user/userUpdate/{id}", method = RequestMethod.POST)
  public String userUpdate(@PathVariable("id") Long id, Users user) {
    Users oldUser = usersService.userDetail(id);

    user.setId(id);
    user.setAccount(oldUser.getAccount());
    user.setEnabled(oldUser.getEnabled());
    user.setJoinDate(oldUser.getJoinDate());
    user.setRole(oldUser.getRole());

    usersService.saveUsers(user);
    return "redirect:/user/userList";
  }

  @RequestMapping(value = "/user/userDelete/{id}", method = RequestMethod.POST)
  public String boardDelete(@PathVariable("id") Long id) {
    usersService.deleteUser(id);

    return "redirect:/user/userList";
  }
}