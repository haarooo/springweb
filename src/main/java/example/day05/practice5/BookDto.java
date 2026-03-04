package example.day05.practice5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private Integer bno;
    private String bname;
    private String bwriter;
    private String publisher;
}
