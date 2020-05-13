package kr.inhatc.spring.model.dto;

import lombok.Data;

@Data
public class BoardDTO {

  private long boardIdx;
  private String title;
  private String content;
  private Integer hitCnt;
  private String createDatetime;
  private String createId;
  private String deleteYn;
  
}