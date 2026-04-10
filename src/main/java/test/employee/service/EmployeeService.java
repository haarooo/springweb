package test.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.department.entity.DepartmentEntity;
import test.department.repository.DepartmentRepository;
import test.employee.dto.EmployeeDto;
import test.employee.entity.EmployeeEntity;
import test.employee.repository.EmployeeRepository;
import test.util.FileService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final FileService fileService;


    //사원등록
    public EmployeeDto employeePost(EmployeeDto employeeDto){
        EmployeeEntity employeeEntity = employeeDto.toEntity();
        Optional<DepartmentEntity> optional = departmentRepository.findById(employeeDto.getDepartmentId());
        if(!optional.isPresent()){return null;}
        employeeEntity.setDepartment(optional.get());

        String fileName = fileService.upload(employeeDto.getMultipartFile());
        if(fileName != null){employeeEntity.setEmployeeImg(fileName);}
        else{employeeEntity.setEmployeeImg("2aeaab56-39c7-414c-9dad-60f630eefe4f_free-icon-profile-18993099.png");}
        EmployeeEntity saved = employeeRepository.save(employeeEntity);
        if (saved.getEmployeeId() >= 0) {return saved.toDto();}
        return null;
    }

    //사원 전체 조회
    public List<EmployeeDto> employeeGet(){
        return employeeRepository.findAll().stream().map(EmployeeEntity::toDto).collect(Collectors.toList());
    }

    // 사원 수정
    public EmployeeDto employeeUpdate(EmployeeDto employeeDto){
        Optional<EmployeeEntity> optional = employeeRepository.findById(employeeDto.getEmployeeId());
        if(optional.isPresent()){
            EmployeeEntity update = optional.get();
            update.setEmployeeId(employeeDto.getEmployeeId());
            update.setEmployeeName(employeeDto.getEmployeeName());
            update.setPosition(employeeDto.getPosition());
            return employeeRepository.save(update).toDto();
        }
        return null;
    }

    //사원 삭제
    public boolean employeeDelete(Long employeeId){
        Optional<EmployeeEntity> optional = employeeRepository.findById(employeeId);
        if(optional.isPresent()){
            employeeRepository.deleteById(employeeId);
            return true;
        }
        return false;
    }



}
