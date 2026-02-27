package example.종합.예제9.controller;


import example.종합.예제9.model.dao.BoardDao;
import example.종합.예제9.model.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired //의존성 주입(DI)
    private BoardDao boardDao;

    @GetMapping
    public List<BoardDto> findAll(){
        List<BoardDto> result = boardDao.findAll(); //dao호출
        return result;
    }

    @PostMapping
    public boolean write(@RequestBody BoardDto boardDto){
        boolean result = boardDao.write(boardDto);
        return result;
    }

    @PutMapping
    public boolean update( @RequestBody BoardDto boardDto ){
        boolean result =  boardDao.update( boardDto );
        return result;
    }

    @DeleteMapping
    public boolean delete(@RequestParam int bno){
        boolean result = boardDao.delete(bno);
        return result;
    }
    //커밋
}
