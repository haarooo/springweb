package example.day05.mvc;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    //R : 조회 select
    public List<ExamDto> findAll(){
        //findAll : 전체조회
        List<ExamEntity> examEntityList = examRepository.findAll();
        //entity --> dto로 변경
        List<ExamDto> examDtoList = new ArrayList<>();
        examEntityList.forEach(entity -> {
            ExamDto examDto = new ExamDto();
            examDto.setEno(entity.getEno());
            examDto.setEname(entity.getEname());
            examDtoList.add(examDto);
        } );
        return examDtoList;
    }
    //C : 쓰기 insert
    public boolean write(ExamDto examDto){
        //.save(엔티티) : 해당 엔티티를 insert 한다
        ExamEntity examEntity = new ExamEntity(); // 엔티티 생성
        examEntity.setEname(examDto.getEname()); // 엔티티에 전달받은 값 넣기
        ExamEntity savedEntity = examRepository.save(examEntity); //받은 dto를 .save(examEntity)로 insert 하고 savedEntity에 저장
        if(savedEntity.getEno() >= 1){return true;} //PK여부로 확인 Eno는 auto_increment이므로 1보다 크면 insert성공
        return false;
    }

    //D : 삭제 delete
    public boolean delete(int eno){
        //.deleteById(삭제할 PK번호)
        examRepository.deleteById(eno);
        return true;
    }

    //U : 수정 update
    @Transactional
    public boolean update(ExamDto examDto){
        // update대신에 jpa 영속성 사용한다
        // 영속성 : 데이터베이스와 자바객체간의 연결되는 상태를 계속적으로 유지
        // 즉 자바객체가 수정되면 데이터베이스도 자동으로 수정
        // 1. 수정할 엔티티 찾기
        Optional<ExamEntity> optional = examRepository.findById(examDto.getEno()); //findById(수정할 pk번호)
        // 2. 만약에 엔티티가 존재하면 : isPresent(); 값이 있으면 true리턴 없으면 false 반환 함수
        if(optional.isPresent()){
            ExamEntity examEntity = optional.get(); //존재한 엔티티 꺼내기
            examEntity.setEname(examDto.getEname()); // 입력받은(수정할) 값을 엔티티에 setter이용하여 수정한다
            return true;
        }
        return false;
    }
}

/*
    1. <> 제네릭타입 , 객체 생성할때 타입 지정
    2. optional<> : 객체내 null값 제어 기능/함수 제공하는 클래스 , 안전
        1. .isPresent() : 만약에 null이면 fasle반환 , null이 아니면 true반환
        2. .get() : 객체 반환
        3. .orElse(null일때값)
        4. .orElseThrow(예외값)
        사용처 : JPA 에서 findById() 반환 타입 그외 몇몇 라이브러리 사용된다.
        사용법 :
           1. Optional<엔티티> 변수명   = repository.findById()
           2. 엔티티 변수명 = repository.findById().orElse()

    3. JPA CRUD 기본 제공
        1. .findAll() : 모든 레코드/객체/엔티티 조회(select) , 반환타입 : List<엔티티명>
        2. findById(조회할 pk번호) : 특정 pk번호의 엔티티 반환 , 반환타입 : Optional <엔티티명>
        3. .save(저장할 엔티티) : 특정 엔티티를 저장(insert) 반환타입 : 엔티티
        4. .deleteById(삭제할 pk번호) : 특정 pk번호의 엔티티 삭제(delete) 반환타입 : void(없음)
        5. 수정함수는 존재하지 않는다 : 영속성 특징
            -영속성 갖는 시점 : save , findAll , findById등등 반환된 엔티티가 영속된 엔티티
            * 영속성이란? 데이터베이스와 자바객체를 연결하는 관계
            - 영속된 엔티티를 .setter 이용하여 객체 수정하면 자동으로 데이터베이스도 반영된다.
            -@Transactional 갖는 클래스/메소드는 여러 SQL들을 하나의 묶음으로 한번에 처리한다
                -즉 트랜잭션이란? 여러 SQL들을 묶어서 하나라도 실패하면 모두 실해(RollBack)모두 성공하면 최종성공(Commit)
                - 예시1] 이체 기능은 1. 입금 2. 출금 2개 이상의 기능을 묶은 기능
                    - 입금과 출금 중에 하나라도 문제가 발생하면 전체 취소
                - 영속된 객체를 .setter 이용하여 여러개 수정함으로써 여러개 수정(update)들을 하나로 처리한다
*/

