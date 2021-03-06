package kr.inhatc.spring.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserOptionList {

  private static final List<String> enabledList = new ArrayList<>() {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    {
      add("가능");
      add("불가능");
    }
  };

  private static final List<String> authorityList = new ArrayList<>() {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    {
      add("ROLE_GUEST");
      add("ROLE_MEMBER");
      add("ROLE_ADMIN");
    }
  };

  private static final Map<String, List<String>> map = new HashMap<>() {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    {
      put("enabledList", enabledList);
      put("authorityList", authorityList);
    }
  };

  public static Map<String, List<String>> getMap() {
    return map;
  }
}