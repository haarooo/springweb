package example.종합.예제10.board.dto;

import aQute.bnd.annotation.headers.BundleLicense;
import example.종합.예제10.board.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
    private Integer bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private String createDate;
    private String updateDate;

    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .bno(bno)
                .btitle(btitle)
                .bwriter(bwriter)
                .bcontent(bcontent)
                .build();
    }
}
