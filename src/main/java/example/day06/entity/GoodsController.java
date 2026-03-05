package example.day06.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/goods")
    public boolean post(@RequestBody GoodsDto goodsDto){
        boolean result = goodsService.post(goodsDto);
        return result;
    }

    @PutMapping("/goods")
    public boolean update(@RequestBody GoodsDto goodsDto){
        boolean result = goodsService.update(goodsDto);
        return result;
    }

}
