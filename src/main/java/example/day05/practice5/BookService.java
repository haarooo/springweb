package example.day05.practice5;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List findAll(){
        List<BookEntity> bookEntityList = bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        bookEntityList.forEach(entity -> {
            BookDto bookDto = new BookDto();
            bookDto.setBno(entity.getBno());
            bookDto.setBname(entity.getBname());
            bookDto.setBwriter(entity.getBwriter());
            bookDto.setPublisher(entity.getPublisher());
            bookDtoList.add(bookDto);
        });
        return bookDtoList;
    }

    public boolean write(BookDto bookDto){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBname(bookDto.getBname());
        bookEntity.setBwriter(bookDto.getBwriter());
        bookEntity.setPublisher(bookDto.getPublisher());
        BookEntity saveEntity = bookRepository.save(bookEntity);
        if(saveEntity.getBno() >= 1){return true;}
        return false;
    }

    public boolean delete(int bno){
        bookRepository.deleteById(bno);
        return true;
    }

    @Transactional //.setBname();, .setBwriter(); .setPublisher(); 3개의 쿼리를 묶어서 처리한다
    public boolean update(BookDto bookDto){
       Optional<BookEntity> optional =  bookRepository.findById(bookDto.getBno());
       if(optional.isPresent()){
           BookEntity bookEntity = optional.get();
           bookEntity.setBname(bookDto.getBname());
           bookEntity.setBwriter(bookDto.getBwriter());
           bookEntity.setPublisher(bookDto.getPublisher());
           return true;
       }
       return false;
    }

}
