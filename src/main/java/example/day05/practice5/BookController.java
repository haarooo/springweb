package example.day05.practice5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practice5")
public class BookController {

    @Autowired
    private  BookService bookService;

    @GetMapping
    public List findAll(){
        List<BookDto> result = bookService.findAll();
        return result;
    }

    @PostMapping
    public boolean write(@RequestBody BookDto bookDto){
        boolean result = bookService.write(bookDto);
        return result;
    }

    @DeleteMapping
    public boolean delete(@RequestParam int bno){
        boolean result = bookService.delete(bno);
        return result;
    }

    @PutMapping
    public boolean update(@RequestBody BookDto bookDto){
        boolean result = bookService.update(bookDto);
        return result;
    }
}
