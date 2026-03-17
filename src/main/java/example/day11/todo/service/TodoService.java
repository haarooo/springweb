package example.day11.todo.service;

import example.day11.todo.dto.TodoDto;
import example.day11.todo.entity.TodoEntity;
import example.day11.todo.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
    private final TodoRepository todoRepository;

    public List<TodoDto> findAll(){

        List<TodoEntity> entityList = todoRepository.findAll();

        //1.
        List<TodoDto> list1 = new ArrayList<>();
        for(int i = 0 ; i<=entityList.size()-1 ; i++){
            TodoEntity entity = entityList.get(i);
            list1.add(entity.toDto());
        }

        //2.
        List<TodoDto> list2 = new ArrayList<>();
        entityList.stream().forEach(entity->{
            list2.add(entity.toDto());
        });

        //3.
        List<TodoDto> list3 = entityList.stream().map(entity-> entity.toDto()).collect(Collectors.toList());

        //4
        List<TodoDto> list4 = entityList.stream().map(TodoEntity::toDto).collect(Collectors.toList());

        return list4;
    }

    public TodoDto findById(int id){

        //방법 2
        TodoDto todoDto = todoRepository.findById(id)
                .map(TodoEntity::toDto)
                .orElse(null); // 만약에 조회가 실패하면 null
        return todoDto;
    }


    // 쿼리메소드 방법
    public TodoDto query1(String title){
        TodoDto todoDto = todoRepository.findByTitle(title).toDto();
        return todoDto;
    }

    //네이티브 메소드 방법
    public TodoDto query2(String title){
        TodoDto todoDto = todoRepository.query2(title).toDto();
        return todoDto;
    }


    // map 활용
    /*
    public Map<String , Object> query3(String title , String content){
        Map<String , Object> map = todoRepository.findByTitleAndContent(title , content);
        return map;
    }
    */

    public Map<String, Object> query3(String title , String content){
        Map<String , Object> map = todoRepository.query3(title , content);
        return map;
    }

    // title이 들어간 검색
    public List<TodoDto> query4(String title){
        List<TodoDto> list = todoRepository.query4(title).stream()
                .map(TodoEntity::toDto)
                .collect(Collectors.toList());
        return list;
    }
    /*
    public List<TodoDto> query4(String title){
        List<TodoDto> list = todoRepository.findByTitleContaining(title).stream()
                .map(TodoEntity::toDto)
                .collect(Collectors.toList());
        return list;
    }
    */

    // 페이징처리
    public Page<TodoDto> page(int page , int size){
        // 1. 페이징 옵션 설정한다.
            // page-1 : JPA는 페이징 번호가 0부터 시작하므로 1페이지는  0 , 2페이지는 1
            // size : 현재 페이지가 조회할 자료/엔티티 개수
            // Sort.by(Sort.Direction.Desc , 정렬기준 필드명)
        PageRequest pageRequest = PageRequest.of(page-1 , size , Sort.by(Sort.Direction.DESC , "id"));
        // 2. findxxx(pageRequest)구현체를 포함한다
        Page<TodoEntity> todoEntityPage = todoRepository.findAll(pageRequest);//전체조회에 대한 페이징처리
        return todoEntityPage.map(TodoEntity::toDto);
    }

    //페이징처리2
    public Page<TodoDto> page2(String keyword , int page , int size){
        PageRequest pageRequest = PageRequest.of(page-1 , size , Sort.by(Sort.Direction.DESC , "id"));
        //전체조회 인지? 키워도 조회인지?
        Page<TodoEntity> result;
        if(keyword==null || keyword.isBlank()){
            result = todoRepository.findAll(pageRequest);
        }else{result= todoRepository.query5(keyword, pageRequest);
        }
        return result.map(TodoEntity::toDto);
    }
}
