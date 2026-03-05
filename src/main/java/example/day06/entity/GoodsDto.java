package example.day06.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GoodsDto  {
    private Integer gno;
    private String gname;
    private String gdesc;
    private Integer gprice;
    //+baseTime
    private String createDate;
    private String updateDate;

    // DTO-->Entity 변환함수
    public GoodsEntity toEntity(){
        //빌더패턴이런? new 생성자가 아닌 함수로 객체를 생성

        return GoodsEntity.builder()
                .gno(this.gno)
                .gname(this.gname)
                .gdesc(this.gdesc)
                .gprice(this.gprice)
                .build();
    }

}
