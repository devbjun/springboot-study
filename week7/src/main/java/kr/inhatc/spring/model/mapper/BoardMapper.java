package kr.inhatc.spring.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.model.dto.BoardDTO;

@Repository
@Mapper
public interface BoardMapper {
  List<BoardDTO> selectBoard();

  void insertBoard(BoardDTO board);

  BoardDTO detailBoard(int boardIdx);

  void updateBoard(BoardDTO board);

  void updateHit(int boardIdx);

  void deleteBoard(int boardIdx);
}