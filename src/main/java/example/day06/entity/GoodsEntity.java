package example.day06.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "goods") // 생략시 클래스명으로 테이블 생성
public class GoodsEntity extends BaseTime {
    @Id //JPA 엔티티내 1개 이상의 primary key 필수로 한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gno; //제품번호

    @Column(name = "제품명" , nullable = false , length = 100 , unique = true)
    private String gname;
    private Integer gprice;

    @Column(columnDefinition = "varchar(100) default '제품설명' not null ")
    private String gdesc;

    // Entitiy --> Dto 변환함수
    public GoodsDto toDto(){
        return GoodsDto.builder()
                .gno(this.gno)
                .gname(this.gname)
                .gdesc(this.gdesc)
                .gprice(this.gprice)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }
}//class e

/*
    @Id : primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
    name = "필드명",
    nullable = false : notnull
    length : 길이, 기본값은 255
    unique = true : 기본값은 false , 중복여부
    updatable = true : 기본값은 true , update할때 적용여부
    insertable = true : 기본값은 true , insert할떄 적용여부
    columnDefinition = 'SQL' : JPA가 아닌 네이티브 쿼리 작성

    )


*/