package pythonML.practice6.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pythonML.practice6.entity.CarEntity;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CarDto {
    private Long id;
    private BigDecimal efficiency;
    private Integer mileage;
    private Integer month;
    private Integer accident;
    private Integer changeUser;
    private Integer price;



    public CarEntity toEntity(){
        return CarEntity.builder()
                .efficiency(efficiency)
                .mileage(mileage)
                .month(month)
                .accident(accident)
                .changeUser(changeUser)
                .price(price)
                .build();
    }

}
