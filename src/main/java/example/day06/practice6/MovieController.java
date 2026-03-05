package example.day06.practice6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping
    public boolean post(@RequestBody MovieDto movieDto){
        boolean result = movieService.post(movieDto);
        return result;
    }


    @GetMapping("/detail")
    public MovieDto detailFind(@RequestParam int mno){
        MovieDto result = movieService.detailFind(mno);
        return  result;
    }


    @GetMapping
    public List<MovieDto> findAll(){
        List<MovieDto> movieList = movieService.findAll();
        return movieList;
    }


    @DeleteMapping
    public boolean delete(@RequestParam int mno){
        boolean result = movieService.delete(mno);
        return result;
    }


    @PutMapping
    public boolean update(@RequestBody MovieDto movieDto){
        boolean reuslt = movieService.update(movieDto);
        return reuslt;
    }



}
