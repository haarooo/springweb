package example.day05.mvc;


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
