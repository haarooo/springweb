package example.day09.책예제;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {
    @Autowired
    private final ArticleRepository articleRepository;

    public ArticleEntity save(ArticleDto articleDto){
        return articleRepository.save(articleDto.toEntity());
    }

    public List<ArticleEntity> findAll(){
        return articleRepository.findAll();
    }

    public ArticleEntity findById(int id){
        return articleRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found" + id));
    }

    public void delete(int id){
        articleRepository.deleteById(id);
    }

    @Transactional
    public ArticleEntity update(int id , UpdateRequest updateRequest){
        ArticleEntity articleEntity = articleRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found : " + id));
        articleEntity.update(updateRequest.getTitle() , updateRequest.getContent());

        articleEntity.setContent( updateRequest.getContent() );


        return articleEntity;
    }

}
