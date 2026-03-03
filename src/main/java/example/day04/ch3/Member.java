package example.day04.ch3;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity //데이터베이스의 테이블 레코드와 매핑(연결) 기술 : ORM(자바객체 <--> DB레코드)
public class Member {

    @Id //PK지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id" , updatable = false) // 필드/속성 설정 , 수정 불가능
    private Long id;

    @Column(name = "name" , nullable = false) // 필드/속성 설정 , not null
    private String name;

}
