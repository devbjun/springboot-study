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

    /*
     * if (!ObjectUtils.isEmpty(multipartHttpServletRequest)) { Iterator<String>
     * iter = multipartHttpServletRequest.getFileNames();
     * 
     * while(iter.hasNext()) { String name = iter.next();
     * 
     * List<MultipartFile> list = multipartHttpServletRequest.getFiles(name); for
     * (MultipartFile multipartFile: list) { log.debug("=======> F_Name: " +
     * multipartFile.getOriginalFilename()); log.debug("=======> F_Size: " +
     * multipartFile.getSize()); log.debug("=======> F_Type: " +
     * multipartFile.getContentType()); } } }
     */

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
    return mapper.detailBoard(boardIdx);
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
}