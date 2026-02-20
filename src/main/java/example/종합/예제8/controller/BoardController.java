package example.종합.예제8.controller;

import example.종합.예제8.model.dao.BoardDao;
import example.종합.예제8.model.dto.BoardDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // 해당 컨트롤러는 HTTP기능 갖게 된다
public class BoardController {

    private BoardDao bd = BoardDao.getInstance();

    // 1. 게시물 등록 controller

    @PostMapping
    public boolean write(String bcontent , String bwriter){
        boolean result = bd.write(bcontent , bwriter);
        return result;
    }

    // 4 게시물삭제
    @DeleteMapping
    public boolean delete(int bno){
        boolean result = bd.delete(bno);
        return result;
    }


    // 3 게시물 수정
    @PutMapping
    public boolean update(int bno , String bcontent){
        boolean result = bd.update(bno , bcontent);
        return result;
    }

    @GetMapping
    //2 게시물 출력
    public ArrayList<BoardDto> findALL(){
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    }

}
