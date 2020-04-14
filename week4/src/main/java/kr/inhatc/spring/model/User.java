package kr.inhatc.spring.model;

public class User {

  private Long id;
  private String number;
  private String name;

  public Long getId() {
    return id;
  }

  public String getNumber() {
    return number;
  }

  public String getName() {
    return name;
  }

  public void setId(Long _id) {
    id = _id;
  }

  public void setNumber(String _number) {
    number = _number;
  }

  public void setName(String _name) {
    name = _name;
  }
  
}