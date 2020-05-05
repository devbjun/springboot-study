package kr.inhatc.spring.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.inhatc.spring.model.dto.BoardDTO;
import kr.inhatc.spring.model.service.BoardService;

@Controller

public class BoardController {

  @Autowired
  BoardService BoardService;

  @RequestMapping(value = "/board/boardList")
  public String boardList(Model model) {

    List<BoardDTO> boardList = BoardService.selectBoard();
    model.addAttribute("list", boardList);

    return "thymeleaf/board/boardList";
  }

  @RequestMapping(value = "/board/boardWrite")
  public String boardWrite() {
    return "thymeleaf/board/boardWrite";
  }

  @RequestMapping(value = "/board/boardInsert")
  public String boardInsert(BoardDTO board) {
    BoardService.insertBoard(board);
    return "redirect:/board/boardList";
  }

  @RequestMapping(value = "/board/boardDetail")
  public String boardDetail(@RequestParam int boardIdx, Model model) {
    
    BoardDTO board = BoardService.detailBoard(boardIdx);
    BoardService.updateHit(boardIdx);
    model.addAttribute("board", board);

    return "thymeleaf/board/boardDetail";
  }

  @RequestMapping(value = "/board/boardUpdate")
  public String boardUpdate(BoardDTO board) {
    BoardService.updateBoard(board);
    return "redirect:/board/boardList";
  }

  @RequestMapping(value = "/board/boardDelete")
  public String boardDelete(@RequestParam("boardIdx") int boardIdx) {
    BoardService.deleteBoard(boardIdx);
    return "redirect:/board/boardList";
  }
}