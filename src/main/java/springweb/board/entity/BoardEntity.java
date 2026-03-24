package springweb.board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;
import springweb.board.dto.BoardDto;
import springweb.member.entity.BaseTime;
import springweb.member.entity.MemberEntity;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
@Entity
@Table(name = "board")
public class BoardEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(nullable = false , length = 255)
    private String btitle;

    @Column(columnDefinition = "longtext" , nullable = false)
    private String bcontent;

    @Column(length = 255) // 첨부파일은 주로 파일자체를 저장하는게 아니라 파일의 위치 저장
    private String bfile;

    // 단방향 : 한명의 회원이 여러개 게시물 작성한다 1:N
    @ManyToOne
    @JoinColumn(name = "mno")@ToStringExclude
    private MemberEntity memberEntity;

    // + toDto : 주로 조회할때
    public BoardDto toDto( ){
        return BoardDto.builder()
                .bno( bno ).btitle( btitle ).bcontent( bcontent ).bfile( bfile )
                .mno( memberEntity.getMno() ) // 작성자FK의 회원번호
                .mname( memberEntity.getMname() ) // 작성자FK의 닉네임
                .build();
    }


}
