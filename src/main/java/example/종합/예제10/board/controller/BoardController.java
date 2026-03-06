package example.종합.예제10.board.controller;


import example.종합.예제10.board.dto.BoardDto;
import example.종합.예제10.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping
    public boolean post(@RequestBody BoardDto boardDto){
        boolean result = boardService.post(boardDto);
        return result;
    }

    @GetMapping
    public List findAll(){
        List<BoardDto> boardDtoList = boardService.findAll();
        return boardDtoList;
    }

    @GetMapping("/detail")
    public BoardDto findDetail(@RequestParam int bno){
        BoardDto boardDto = boardService.findDetail(bno);
        return boardDto;
    }

    @PutMapping
    public boolean update(@RequestBody BoardDto boardDto){
        boolean result = boardService.update(boardDto);
        return result;
    }

    @DeleteMapping
    public boolean delete(@RequestParam int bno){
        boolean result = boardService.delete(bno);
        return result;
    }



}
