package test.department.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.department.dto.DepartmentDto;
import test.department.entity.DepartmentEntity;
import test.department.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;


    //부서 등록
    public DepartmentDto departPost(DepartmentDto departmentDto){
        return departmentRepository.save(departmentDto.toEntity()).toDto();
    }

    //부서 조회
    public List<DepartmentDto> departGet(){
        List<DepartmentDto> dtoList = departmentRepository.findAll().stream().map(DepartmentEntity::toDto).collect(Collectors.toList());
        if(dtoList==null){return null;}
        return dtoList;
    }

    //부서 수정
    public DepartmentDto departUpdate(DepartmentDto departmentDto){
        Optional<DepartmentEntity> optional =departmentRepository.findById(departmentDto.getDepartmentId());
        if(optional.isPresent()){
            DepartmentEntity update = optional.get();
            update.setDepartmentId(departmentDto.getDepartmentId());
            update.setDepartmentName(departmentDto.getDepartmentName());
            departmentRepository.save(update);
            return update.toDto();
        }
        return null;
    }

    //부서 삭제
    public boolean departDelete(Long departmentId){
        Optional<DepartmentEntity> optional = departmentRepository.findById(departmentId);
        if(optional.isPresent()){
            departmentRepository.deleteById(departmentId);
            return true;
        }
        return false;
    }


}
