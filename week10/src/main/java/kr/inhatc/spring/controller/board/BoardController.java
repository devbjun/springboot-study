package kr.inhatc.spring.controller.board;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.model.dto.BoardDTO;
import kr.inhatc.spring.model.dto.FileDTO;
import kr.inhatc.spring.model.service.BoardService;

@Controller
public class BoardController {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  BoardService BoardService;

  @RequestMapping(value = "/board/boardList", method = RequestMethod.GET)
  public String boardList(Model model) {

    List<BoardDTO> boardList = BoardService.selectBoard();
    model.addAttribute("list", boardList);

    log.debug("=======> " + boardList.size());

    return "thymeleaf/board/boardList";
  }

  @RequestMapping(value = "/board/boardInsert", method = RequestMethod.GET)
  public String boardWrite() {
    return "thymeleaf/board/boardWrite";
  }

  @RequestMapping(value = "/board/boardInsert", method = RequestMethod.POST)
  public String boardInsert(BoardDTO board, MultipartHttpServletRequest multipartHttpServletRequest) {
    BoardService.insertBoard(board, multipartHttpServletRequest);
    return "redirect:/board/boardList";
  }

  @RequestMapping(value = "/board/boardDetail", method = RequestMethod.GET)
  public String boardDetail(@RequestParam int boardIdx, Model model) {

    BoardDTO board = BoardService.detailBoard(boardIdx);
    BoardService.updateHit(boardIdx);
    model.addAttribute("board", board);

    return "thymeleaf/board/boardDetail";
  }

  @RequestMapping(value = "/board/boardUpdate", method = RequestMethod.POST)
  public String boardUpdate(BoardDTO board) {
    BoardService.updateBoard(board);
    return "redirect:/board/boardList";
  }

  @RequestMapping(value = "/board/boardDelete", method = RequestMethod.GET)
  public String boardDelete(@RequestParam("boardIdx") int boardIdx) {
    BoardService.deleteBoard(boardIdx);
    return "redirect:/board/boardList";
  }

  @RequestMapping(value = "/board/boardDownloadFile", method = RequestMethod.GET)
  public void boardDownloadFile(@RequestParam("idx") int idx, @RequestParam("boardIdx") int boardIdx,
      HttpServletResponse response) throws IOException {
    
    FileDTO boardFile = BoardService.selectFile(idx, boardIdx);

    if (!ObjectUtils.isEmpty(boardFile)) {
      String fileName = boardFile.getOriginalFileName();
      byte[] files = FileUtils.readFileToByteArray(new File(boardFile.getStoredFilePath()));

      response.setContentType("application/octet-stream");
      response.setContentLength(files.length);
      response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
      response.setHeader("Content-Transfer-Encoding", "binary");
      response.getOutputStream().write(files);
      response.getOutputStream().flush();
      response.getOutputStream().close();
    }
  }
}