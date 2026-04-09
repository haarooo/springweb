package test.department.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.department.entity.DepartmentEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private Long departmentId;
    private String departmentName;
    private String createDate;
    private String updateDate;


    public DepartmentEntity toEntity(){
        return DepartmentEntity.builder()
                .departmentId(departmentId)
                .departmentName(departmentName)
                .build();
    }

}
