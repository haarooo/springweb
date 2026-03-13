package example.day09.책예제;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ViewController {
    private final ArticleService articleService;

    @GetMapping("/article")
    public String get(Model model){
        List<ListViewResponse> articles = articleService.findAll().stream()
                .map(ListViewResponse::new)
                .toList();
        System.out.println("articles = " + articles);
        model.addAttribute("articles" , articles);
        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String get(@PathVariable int id , Model model){
        ArticleEntity articleEntity = articleService.findById(id);
        model.addAttribute("article" ,new ViewResponse(articleEntity));
        return "article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Integer id , Model model){
        if(id == null){
            model.addAttribute("article", new ViewResponse());
        }else{
            ArticleEntity articleEntity = articleService.findById(id);
            model.addAttribute("article",new ViewResponse(articleEntity));
        }
        return "newArticle";
    }
}
