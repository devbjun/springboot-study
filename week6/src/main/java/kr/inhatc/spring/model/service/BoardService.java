package kr.inhatc.spring.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.model.dto.BoardDTO;
import kr.inhatc.spring.model.mapper.BoardMapper;

@Service
public class BoardService {

  @Autowired
  public BoardMapper mapper;

  public List<BoardDTO> selectBoard() {
    return mapper.selectBoard();
  }

  public void insertBoard(BoardDTO board) {
    mapper.insertBoard(board);
  }

  public BoardDTO detailBoard(int boardIdx) {
    return mapper.detailBoard(boardIdx);
  }
}