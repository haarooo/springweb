package example.종합.예제10.board.controller;


import example.종합.예제10.board.dto.CommentDto;
import example.종합.예제10.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List findAll(@RequestParam int bno){
        List<CommentDto> commentDtoList = commentService.findAll(bno);
        return commentDtoList;
    }

    @PostMapping
    public boolean post(@RequestBody CommentDto commentDto){
        boolean result = commentService.post(commentDto);
        return result;
    }

    @PutMapping
    public boolean update(@RequestBody CommentDto commentDto){
        boolean result = commentService.update(commentDto);
        return result;
    }

    @DeleteMapping
    public boolean delete(@RequestParam int cno){
        boolean result = commentService.delete(cno);
        return result;
    }
}
