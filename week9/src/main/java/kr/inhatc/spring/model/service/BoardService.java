package kr.inhatc.spring.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.model.dto.BoardDTO;
import kr.inhatc.spring.model.dto.FileDTO;
import kr.inhatc.spring.model.mapper.BoardMapper;
import kr.inhatc.spring.utils.FileUtils;

@Service
public class BoardService {

  @Autowired
  public BoardMapper mapper;

  @Autowired
  private FileUtils fileUtils;

  public List<BoardDTO> selectBoard() {
    return mapper.selectBoard();
  }

  public void insertBoard(BoardDTO board, MultipartHttpServletRequest multipartHttpServletRequest) {
    
    mapper.insertBoard(board);
    List<FileDTO> list;

    try {
      // 파일 저장
      list = fileUtils.parseFileInfo(board.getBoardIdx(), multipartHttpServletRequest);
      
      // DB 저장
      if (!CollectionUtils.isEmpty(list))
        mapper.insertBoardFile(list);

    } catch (IllegalStateException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public BoardDTO detailBoard(int boardIdx) {
    BoardDTO board = mapper.detailBoard(boardIdx);
    List<FileDTO> fileList = mapper.detailFileList(boardIdx);

    board.setFileList(fileList);
    
    return board;
  }

  public void updateBoard(BoardDTO board) {
    mapper.updateBoard(board);
  }

  public void updateHit(int boardIdx) {
    mapper.updateHit(boardIdx);
  }

  public void deleteBoard(int boardIdx) {
    mapper.deleteBoard(boardIdx);
  }

  public FileDTO selectFile(int idx, int boardIdx) {
    return mapper.selectFile(idx, boardIdx);
  }
}