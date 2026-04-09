package test.department.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import test.department.dto.DepartmentDto;
import test.util.BaseTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department")
public class DepartmentEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long departmentId;

    @Column(name = "department_name" , unique = true)
    String departmentName;


    public DepartmentDto toDto(){
        return DepartmentDto.builder()
                .departmentId(departmentId)
                .departmentName(departmentName)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }
}
