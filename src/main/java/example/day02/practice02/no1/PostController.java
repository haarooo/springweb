package example.day02.practice02.no1;


import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/practice2")
public class PostController {

    //1.
    @PostMapping("/post")
    public boolean method1(){
        System.out.println("PostController.method1");
        return true;
    }

    @GetMapping("/post")
    public List method2(){
        List<Map<String ,String>>list = new ArrayList<>();
        Map<String , String> map = new HashMap<>();
        map.put( "pno" , "1");
        map.put( "ptitle" , "제목1");

        Map<String , String> map2 = new HashMap<>();
        map2.put("pno" , "2");
        map2.put("ptitle" , "제목2");
        list.add(map);
        list.add(map2);
        return list;
    }

    @GetMapping("/post/view")
    public Map method3(){
        Map<String , String> map3 = new HashMap<>();
        map3.put("pno" , "3");
        map3.put("ptitle" , "제목3");
        return map3;
    }

    @PutMapping("/post")
    public boolean method4(){
        return true;
    }

    @DeleteMapping("/post")
    public int method5(){
        return 3;
    }








}
