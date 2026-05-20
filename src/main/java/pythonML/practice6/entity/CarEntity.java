package pythonML.practice6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pythonML.practice6.dto.CarDto;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "efficiency")
    private BigDecimal efficiency;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "month")
    private Integer month;

    @Column(name = "accident")
    private Integer accident;

    @Column(name = "change_user")
    private Integer changeUser;

    @Column(name = "price")
    private Integer price;

    public CarDto toDto(){
        return CarDto.builder()
                .efficiency(efficiency)
                .mileage(mileage)
                .month(month)
                .accident(accident)
                .changeUser(changeUser)
                .price(price)
                .build();
    }



}
