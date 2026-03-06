package example.종합.예제10.board.service;

import example.종합.예제10.board.dto.CommentDto;
import example.종합.예제10.board.entity.BoardEntity;
import example.종합.예제10.board.entity.CommentEntity;
import example.종합.예제10.board.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<CommentDto> findAll(int bno){
        List<CommentEntity> commentEntityList = commentRepository.findAll();
        List<CommentDto> commentDtoList = new ArrayList<>();
        commentEntityList.forEach(entity -> {
            if(entity.getBno() == bno) {
                commentDtoList.add(entity.toDto());
            }
        });
        return commentDtoList;
    }

    public boolean post(CommentDto commentDto){
        CommentEntity comment = commentDto.toEntity();
        CommentEntity save = commentRepository.save(comment);
        if(save.getCno() >= 1){return true;}
        return false;
    }

    public boolean delete(int cno){
        Optional<CommentEntity> optional = commentRepository.findById(cno);
        if(optional.isPresent()){
            commentRepository.deleteById(cno);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean update(CommentDto commentDto){
        Optional<CommentEntity> optional = commentRepository.findById(commentDto.getCno());
        if(optional.isPresent()){
            CommentEntity commentEntity = optional.get();
            commentEntity.setComment(commentDto.getComment());
            commentEntity.setCwriter(commentDto.getCwriter());
            return true;
        }
        return false;
    }
}
