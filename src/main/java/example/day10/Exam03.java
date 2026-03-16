package example.day10;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exam03 {
    public static void main(String[] args) {
        // 람다표현식 , (매개변수)->{구현부}
        // 스트림API : 데이터(매개변수) --> 중간연산 --> 최종출력

        List<Integer> number = List.of(1,2,3,4,5,6,7,8,9,10);
        // 1. 리스트변수명.stream().forEach() , 중간연산 없이 바로 최종출력
        // 매개변수에 반복변수를 하나씩 대입하여 return 없는 반복문
        number.stream().forEach( (x) -> {System.out.print(x*2 + "\t");} );
        
        // 2. 리스트변수명.stream().map(중간연산).collect(최종출력);
        List<Integer> result = 
            number.stream().map( (x)-> {return x*2;}).collect(Collectors.toList());
        System.out.println("\n result = " + result);

        // 3. 리스트변수명.stream().map(중간연산).forEach(최종출력)
        number.stream().map(x->x*2).forEach( result2-> System.out.println("result2 = " + result2));

        // 4. 리스트변수명.stream().filter(중간연산)
        number.stream().filter(x -> x%2 ==0).forEach( y-> {System.out.println("y = " + y);});
        
        // 5. 
        number.stream()
                .sorted(Comparator.reverseOrder()) // 중간연산 , 오름차순 , 내림차순
                .forEach(y-> System.out.println("y = " + y));

        // 6.
        number.stream()
                .distinct() //중복제거
                .collect(Collectors.toList());
        
        // 7. 
        number.stream()
                .limit(5) // 중간연산 , 앞에서부터 N개까지
                .forEach( y-> System.out.println("y = " + y));

        /*
            스트림이란? 데이터 다니는 연속적인 흐름
                -데이터들 --> 중간연산 --> 최종연산
                -중간연산은 여러개 가능
                -최종연산은 반드시 1개 이상
            주요연산
                -중간연산 : .map()/.filter()/.sorted()/.distinct()/.limit()
                -최종연산 : .forEach/.collect()
        */
    }// main e
}// class e
