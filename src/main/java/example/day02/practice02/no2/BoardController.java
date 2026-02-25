package example.day02.practice02.no2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @PostMapping("/d")
    public boolean boardWrite(@ModelAttribute BoardDto boardDto){

        return true;
    }

    @GetMapping
    public ArrayList boardPrint(){
        ArrayList<BoardDto> boardDtos = new ArrayList<>();
        boardDtos.add(new BoardDto(1, "안녕하세요", "유재석"));
        boardDtos.add(new BoardDto(2, "안녕하세요2", "강호동"));
        return boardDtos;
    }
    @GetMapping("/detail")
    public BoardDto boardDetail(@RequestParam int bno){
        BoardDto boardDto = new BoardDto();
        boardDto.bno = 1;
        boardDto.bcontent = "안녕하세요";
        boardDto.bwriter = "유재석";
        return boardDto;
    }



}

class BoardDto{int bno; String bcontent; String bwriter;

    public BoardDto(){}
    public BoardDto(int bno, String bcontent, String bwriter) {
        this.bno = bno;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }

    public int getBno() {return bno;}
    public void setBno(int bno) {this.bno = bno;}
    public String getBcontent() {return bcontent;}
    public void setBcontent(String bcontent) {this.bcontent = bcontent;}
    public String getBwriter() {return bwriter;}
    public void setBwriter(String bwriter) {this.bwriter = bwriter;}

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", bcontent='" + bcontent + '\'' +
                ", bwriter='" + bwriter + '\'' +
                '}';
    }
}
