package example.day06.entity;

import jakarta.transaction.Transactional;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public boolean post(GoodsDto goodsDto){
        //dto-->entity 변환
        GoodsEntity goodsEntity = goodsDto.toEntity();
        GoodsEntity saved = goodsRepository.save(goodsEntity);
        if(saved.getGno() <= 1){return true;}
        return false;
    }

    @Transactional
    public boolean update(GoodsDto goodsDto){
        Optional<GoodsEntity> optional = goodsRepository.findById(goodsDto.getGno());
        if(optional.isPresent()){
            GoodsEntity goodsEntity = optional.get();
            goodsEntity.setGname(goodsDto.getGname());
            goodsEntity.setGdesc(goodsDto.getGdesc());
            goodsEntity.setGprice(goodsEntity.getGprice());
            return true;
        }
        else{return false;}

    }
}
