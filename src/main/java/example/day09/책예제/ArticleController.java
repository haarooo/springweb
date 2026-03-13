package example.day09.책예제;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {
    private  final ArticleService articleService;

    @PostMapping("/blog")
    public ResponseEntity<ArticleEntity> add(@RequestBody ArticleDto articleDto){
        ArticleEntity save = articleService.save(articleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
    @GetMapping("/blog")
    public ResponseEntity<List<ArticleResponse>> findAll(){
        List<ArticleResponse> articles = articleService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();
        return ResponseEntity.ok().body(articles);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable int id){
        ArticleEntity articleEntity = articleService.findById(id);
        return ResponseEntity.ok().body(new ArticleResponse(articleEntity));
    }
    @DeleteMapping("/blog/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        articleService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/blog/{id}")
    public ResponseEntity<ArticleEntity> update(@PathVariable int id, @RequestBody UpdateRequest updateRequest){
        ArticleEntity articleEntity = articleService.update(id , updateRequest);
        return ResponseEntity.ok().body(articleEntity);
    }

}
