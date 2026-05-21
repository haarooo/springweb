package pythonML.practice9.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pythonML.practice9.entity.FashionEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FashionDto {

    private Integer id;
    private Integer age;
    private Integer gender;
    private Integer inflow;
    private Integer style;
    private Integer category;


    public FashionEntity toEntity(){
        return FashionEntity.builder()
                .age(age)
                .gender(gender)
                .inflow(inflow)
                .style(style)
                .category(category)
                .build();
    }
}
