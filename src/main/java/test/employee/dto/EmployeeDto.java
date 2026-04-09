package test.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import test.employee.entity.EmployeeEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long employeeId;
    private String employeeName;
    private String position;
    private String employeeImg;
    private Long departmentId;
    private String createDate;
    private String updateDate;

    private MultipartFile multipartFile;

    public EmployeeEntity toEntity(){
        return EmployeeEntity.builder()
                .employeeId(employeeId)
                .employeeName(employeeName)
                .position(position)
                .employeeImg(employeeImg)
                .build();
    }
}
