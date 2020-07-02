package kr.ac.inhatc.controller;

import java.util.HashMap;
import java.util.Map;

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
  public Map<String, String> build(@RequestBody HashMap<String, Object> body) {
    Map<String, String> map = new HashMap<>();

    try {
      String result = GraalScript.runScript(body.get("mode").toString(), body.get("code").toString());

      if (result.equals("undefined") || result.equals("None")) {
        map.put("state", "warning");
        map.put("message", "실행 결과가 존재하지 않습니다.");

        return map;
      }

      map.put("state", "success");
      map.put("message", result);
  
      return map;
    }
    catch (Exception e) {
      map.put("state", "danger");
      map.put("message", e.getMessage());

      return map;
    }
  }
}