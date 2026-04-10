package test.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;
import test.department.entity.DepartmentEntity;
import test.employee.dto.EmployeeDto;
import test.util.BaseTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "position")
    private String position;

    @Column(name = "employee_img" , columnDefinition = "LONGTEXT")
    private String employeeImg;

    @ManyToOne
    @JoinColumn(name = "department")
    private DepartmentEntity department;

    public EmployeeDto toDto(){
        return EmployeeDto.builder()
                .employeeId(employeeId)
                .employeeName(employeeName)
                .position(position)
                .employeeImg(employeeImg)
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }
}
