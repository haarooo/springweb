package example.종합.예제9.model.dto;


import aQute.bnd.annotation.headers.BundleLicense;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDto {
    private Integer bno; //int->Integer 사용하요 null 값 대응
    private String bcontent;
    private String bwriter;
    private String bdate;
}
