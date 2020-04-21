package kr.inhatc.spring.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.inhatc.spring.model.dto.BoardDTO;
import kr.inhatc.spring.model.service.BoardService;

@Controller
public class BoardController {

  @Autowired
  BoardService BoardService;

  @RequestMapping(value = "/board/boardList.do")
  public String boardList(Model model) {

    List<BoardDTO> boardList = BoardService.selectBoard();
    model.addAttribute("list", boardList);

    return "thymeleaf/board/boardList";
  }
}