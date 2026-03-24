package springweb.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springweb.board.dto.BoardDto;
import springweb.board.entity.BoardEntity;
import springweb.board.repositroy.BoardRepository;
import springweb.member.entity.MemberEntity;
import springweb.member.repositroy.MemberRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public boolean write(BoardDto boardDto , String loginMid){
        // 1. dto --> entity변환
        BoardEntity boardEntity = boardDto.toEntity();
        // 저장하기 전에 FK 대입하기
        // 현재 로그인중인 Mid로 엔티티 찾기
        Optional<MemberEntity> optional = memberRepository.findByMid(loginMid);
        if(!optional.isPresent()){
            return false; //존지하지 않은 회원
        }
        // 저장할 게시물 엔티티에 set참조 엔티티(회원 엔티티)
        boardEntity.setMemberEntity(optional.get());
        BoardEntity saved = boardRepository.save(boardEntity);
        if(saved.getBno()>=0){return true;}
        else{return false;}



    }
}
