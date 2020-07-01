package kr.ac.inhatc.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.inhatc.util.GraalScript;

@Controller
public class IndexController {

  @RequestMapping(value = "/")
  public String thymeleafIndex(Model model) {
    return "index";
  }

  @ResponseBody
  @RequestMapping(path = "/build", method = RequestMethod.POST)
  public String build(@RequestBody HashMap<String, Object> body) {
    return GraalScript.runScript(body.get("code").toString());
  }
}