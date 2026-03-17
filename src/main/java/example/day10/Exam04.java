package example.day10;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exam04 {
    public static void main(String[] args) {
        //메소드 레퍼런스 API : 이미 정의된 메소드를 참조하여 사용하는 표현식
            // 1. 일반메소드 , member.add( 3 , 4)
            // 2. 람다메소드 , (a , b) -> { return a+b;}
            // 3. 레퍼런스API , member::add(3,4)
        
        // 1. static 정적메소드 예시
        Integer.parseInt("10"); // Integer.parseInt(문자); 문자->정수 타입 반환 함수

        Function<String , Integer> function = Integer::parseInt;
        System.out.println("function.apply(\"10\") = " + function.apply("10"));


        // 2. 일반 메소드 예시
        List<String> names = List.of("유재석" , "강호동" , "신동엽");
            // 2-1 일반 for문
            for(int i = 0 ; i <names.size() ; i++){
            System.out.println("names.get(i) = " + names.get(i));
            }
            // 2-2 forEach
            names.forEach((x)->{System.out.println("x = " + x);});
            // 2-3 forEach + 레퍼런스API()
            names.stream().forEach(System.out::println); // map(Entity::toDto)

        // 3. 생성자 예시
            // 3-1 for문 리스트내 이름 하나씩 꺼내서 객체 생성
            for(int i=0 ; i<names.size() ; i++){
                Post post = new Post(names.get(i));
            }
            // 3-2 forEach문
            names.stream().forEach((x)->{new Post(x);});
            // 3-3 forEach + 레퍼런스API
            names.stream().forEach(Post::new);
            // 활용
            List<Post> postList = names.stream()
                    //.map((x)->{return new Post(x);})
                    .map(Post::new)
                    .collect(Collectors.toList());

    }//main e
}//class e

class Post{
    String name;
    Post(String name){
        this.name = name;
    }
}