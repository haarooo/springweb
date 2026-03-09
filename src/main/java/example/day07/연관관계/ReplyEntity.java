package example.day07.연관관계;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
@Entity
@Table(name = "reply")
public class ReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rno;
    private String rcontent;

    // 단뱡향 FK 만들기
    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER )
    @JoinColumn(name = "bno")
    private BoardEntity boardEntity;

    /*
       - 영속성이란? 자바 객체와 데이터베이스 데이터간 매핑/연결 상태
        - 영속성 해제란? 자바객체와 데이터베이스 데이터간 매핑/연결 해제
       - cascade 속성이란? PK와 FK 제약조건
           CascadeType.ALL : 부모가 삭제/수정/저장 되면 자식도 같이 반영
           CascadeType.Remove : 부모가 삭제되면 자식도 같이 삭제  = on delete cascade
           CascadeType.Merge : 부모가 수정되면 자식도 같이 수정 = on update cascade
           CascadeType.DETACH : 부모가 영속 해제되면 자식도 같이 영속 해제된다
           CascadeType.Refresh : 부모가 재호출(갱신)되면 자식도 같이 재호출(갱신)한다.
           CascadeType.Persist : 부모가 저장되면 자식도 같이 저장된다
       - fetch : 부모(pk) 조회시 자식[fk] 관계에서 엔티티 조회여부 선택
            FetchType.EAGER : (기본값) 해당 엔티티 조회시 참조 엔티티 모두 즉시 조회한다.
                - 특징 : 초기 로딩 느리다, 재사용시 빠르다 , 불필요한 정보까지 있을경우 성능저하
            FetchType.LAZY : 해당 엔티티 조회시 참조 엔티티는 조회하지 않는다 <참조 엔티티 호출시 조회>
                - 특징 : 초기 로딩 빠르다 , 재사용성 느리다 + 필요한 정보만 호출 + <지연로딩>
       - 단뱡향/양방향 활용
       - 만약에 1번 카테고리에 게시물 등록
            BoardEntity saveEntity = new BoardEntity();
            Category category = repository.findById(1).get();
            saveEntity.setcategoryEntity(category)[o]
            repository.save(saveEntity);

       - 만약에 3번 게시물에 댓글 등록
            ReplyEntity saveEntity = new ReplyEntity();
                BoardEntity board = repository.findById(3).get();
                saveEntity.setBoardEntity(board)
                repository.save(saveEntity)

    */
}
