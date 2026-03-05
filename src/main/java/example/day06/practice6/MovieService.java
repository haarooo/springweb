package example.day06.practice6;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public boolean post(MovieDto movieDto){
       MovieEntity movieEntity =  movieDto.toEntity();
       MovieEntity saved = movieRepository.save(movieEntity);
       if(saved.getMno() >= 1){return true;}
       else{return false;}
    }

    public List<MovieDto> findAll(){
        List<MovieEntity> movieEntityList = movieRepository.findAll();
        List<MovieDto> movieDtoList = new ArrayList<>();
        movieEntityList.forEach(movieEntity -> {

            movieDtoList.add(movieEntity.toDto());

            /* MovieDto movieDto = MovieDto.builder()
                    .mno(movieEntity.getMno())
                    .title(movieEntity.getTitle())
                    .director(movieEntity.getDirector())
                    .releasedate(movieEntity.getReleasedate())
                    .rating(movieEntity.getRating())
                    .build();
            movieDtoList.add(movieDto);
            */
        });
        return movieDtoList;
    }

    public MovieDto detailFind(int mno){
        Optional<MovieEntity> optional = movieRepository.findById(mno);
        if(optional.isPresent()){
            MovieDto movieDto = optional.get().toDto();
            return movieDto;
        }
        return null;
    }

    public boolean delete(int mno){
        Optional<MovieEntity> optional = movieRepository.findById(mno);
        if(optional.isPresent()){
            movieRepository.deleteById(mno);
            return true;
        }
        else{return false;}
    }

    @Transactional
    public boolean update(MovieDto movieDto){
        Optional<MovieEntity> optional = movieRepository.findById(movieDto.getMno());
        if(optional.isPresent()){
            MovieEntity movieEntity = optional.get();
            movieEntity.setDirector(movieDto.getDirector());
            movieEntity.setRating(movieDto.getRating());
            movieEntity.setTitle(movieDto.getTitle());
            movieEntity.setReleasedate(movieDto.getReleasedate());
            return true;
        }
        else{return false;}
    }




}
