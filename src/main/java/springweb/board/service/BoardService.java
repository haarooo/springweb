package springweb.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import springweb.board.dto.BoardDto;
import springweb.board.entity.BoardEntity;
import springweb.board.repositroy.BoardRepository;
import springweb.member.entity.MemberEntity;
import springweb.member.repositroy.MemberRepository;
import springweb.util.FileService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final FileService fileService;

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

        // 최종 DB에 save하기 전에 첨부파일 존재하면 업로드
        String fileName = fileService.upload(boardDto.getMultipartFile());
        if(fileName != null){boardEntity.setBfile(fileName);}


        BoardEntity saved = boardRepository.save(boardEntity);
        if(saved.getBno()>=0){return true;}
        else{return false;}

    }


    public List<BoardDto> findAll(){
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC , "bno"))
                .stream()
                //filter() , 조건 가능(짝수만 출력)
                .map(BoardEntity::toDto)
                .collect(Collectors.toList());
    }

    public BoardDto detail(Long bno){
        return boardRepository.findById(bno)
                .orElse(null) // 엔티티가 없으면
                .toDto();
    }













}
