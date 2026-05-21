package pythonML.practice9.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pythonML.practice9.dto.FashionDto;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "fashion")
public class FashionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "inflow")
    private Integer inflow;

    @Column(name = "style" , columnDefinition = " integer default 0")
    private Integer style;

    @Column(name = "category")
    private Integer category;

    public FashionDto toDto(){
        return FashionDto.builder()
                .age(age)
                .gender(gender)
                .inflow(inflow)
                .style(style)
                .category(category)
                .build();
    }

}
