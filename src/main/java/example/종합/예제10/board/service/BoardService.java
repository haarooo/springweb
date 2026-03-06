package example.종합.예제10.board.service;

import example.종합.예제10.board.dto.BoardDto;
import example.종합.예제10.board.entity.BoardEntity;
import example.종합.예제10.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.hibernate.usertype.LoggableUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public boolean post(BoardDto boardDto){
        BoardEntity boardEntity = boardDto.toEntity();
        BoardEntity saveEntity = boardRepository.save(boardEntity);
        if(saveEntity.getBno() >= 1){return true;}
        return false;
    }

    public List<BoardDto> findAll(){
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();
        boardEntityList.forEach(entity -> {
            boardDtoList.add(entity.toDto());
        });
        return boardDtoList;
    }

    public BoardDto findDetail(int bno){
        Optional<BoardEntity> optional = boardRepository.findById(bno);
        if(optional.isPresent()){
            BoardEntity boardEntity = optional.get();
            BoardDto boardDto = boardEntity.toDto();
            return boardDto;
        }
        return null;
    }
    @Transactional
    public boolean update(BoardDto boardDto){
        Optional<BoardEntity> optional = boardRepository.findById(boardDto.getBno());
        if(optional.isPresent()){
            BoardEntity boardEntity = optional.get();
            boardEntity.setBtitle(boardDto.getBtitle());
            boardEntity.setBcontent(boardDto.getBcontent());
            boardEntity.setBwriter(boardDto.getBwriter());
            return true;
        }
        return false;
    }

    public boolean delete(int bno){
       Optional<BoardEntity> optional = boardRepository.findById(bno);
       if(optional.isPresent()){
       boardRepository.deleteById(bno);

       return true;
       }
       return false;
    }

}
