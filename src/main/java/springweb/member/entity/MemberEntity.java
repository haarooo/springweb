package springweb.member.entity;

import example.day04.ch3.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import springweb.member.dto.MemberDto;

@NoArgsConstructor@AllArgsConstructor@Data@Builder
@Entity
@Table(name = "member")
public class MemberEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(nullable = false , unique = true , length = 100)
    private String mid;

    @Column(nullable = false)
    private String mpwd;

    @Column(nullable = false , length = 30)
    private String mname;


    public MemberDto toDto(){
        return MemberDto.builder()
                .mid(mid)
                //.mpwd(mpwd)
                .mname(mname)
                .mno(mno)
                .updateDate(getUpdateDate().toString())
                .createDate(getCreateDate().toString())
                .build();

    }


}
