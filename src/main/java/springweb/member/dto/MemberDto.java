package springweb.member.dto;

import example.day04.ch3.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springweb.member.entity.MemberEntity;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class MemberDto {

    private Long mno;
    private String mid;
    private String mpwd;
    private String mname;

    private String createDate;
    private String updateDate;


    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .mid(mid)
                .mno(mno)
                .mname(mname)
                .mpwd(mpwd)
                .build();
    }
}
